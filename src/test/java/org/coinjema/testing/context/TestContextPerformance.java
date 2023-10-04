package org.coinjema.testing.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextFactory;
import org.coinjema.cjm.util.Functor;
import org.coinjema.testing.nontest.*;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestContextPerformance extends AbstractContextTester {
    String[] paths = new String[]{"path1", "path2"};
    CjmContext[] contexts = new CjmContext[]{new CjmContext(),
            new CjmContext("config2"), new CjmContext("custom"),
            new CjmContext("custom/units"),
            new CjmContext("custom/units/elf"),
            new CjmContext("custom/units/orc"),
            new CjmContext("override"), new CjmContext("units"),
            new CjmContext("units/elf"), new CjmContext("units/orc")};
    String[] testPaths = new String[]{"path1", "path1", "path1",
            "custom/units/", "custom/units/elf", "custom/units/orc", "path3",
            "units/", "elf_path1", "orc_path1"};


    @Test
    public void testPerformance() throws Exception {
        int i = 0;
        while (i++ < 1000) {
            PerformanceTestObject co = new PerformanceTestObject(contexts[i
                    % contexts.length]);
        }
        System.out.println("Saved objects = "
                + ContextFactory.getContextObjectCount());
        i = 0;
        while (i++ < 1000) {
            BasicObject bo = new BasicObject();
            bo.setPaths(paths);
            bo.setLogger();
        }
        i = 0;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        i = 0;
        long normalTime = System.currentTimeMillis();
        while (i++ < 1000000) {
            BasicObject bo = new BasicObject();
            bo.setPaths(paths);
            bo.setLogger();
            int index = i % paths.length;
            assertEquals(paths[index], bo.getPaths()[index]);
        }
        normalTime = (System.currentTimeMillis() - normalTime);
        long aopTime = System.currentTimeMillis();
        i = 0;
        while (i++ < 1000000) {
            int index = i % contexts.length;
            PerformanceTestObject co = new PerformanceTestObject(
                    contexts[index]);
            assertEquals(testPaths[index], co.getPaths()[0]);
        }
        aopTime = (System.currentTimeMillis() - aopTime);
        System.out.println("Saved objects = "
                + ContextFactory.getContextObjectCount());

        System.gc();
        Thread.currentThread().sleep(100);
        System.out.println("AOP Time = " + aopTime);
        System.out.println("Normal Time = " + normalTime);
        // assertTrue(aopTime / normalTime <= 50);

        System.out.println("Saved objects = "
                + ContextFactory.getContextObjectCount());

    }

    @Test
    public void testTheConcurrencyChallenge() throws Exception {
        // for(int j = 0;j < 50;j++) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorService threadPool = Executors.newVirtualThreadPerTaskExecutor();
        List dynProps = new LinkedList();
        Functor getPropsa = new Functor(new AdvancedContextObject(),
                "getDynamicProperties");
        Functor getPropsb = new Functor(new AdvancedContextObject(
                new CjmContext("custom")), "getDynamicProperties");
        Functor refresher = new Functor(ContextFactory.getRegistry(""), "refresh");
        List inits = new LinkedList();
        Constructor c = BasicContextOriented.class
                .getConstructor(CjmContext.class);
        List init2 = new LinkedList();
        Constructor s = SimpleContextOrientedB.class
                .getConstructor(CjmContext.class);
        CjmContext root = new CjmContext();
        CjmContext unitsOrc = new CjmContext("units/orc");
        CjmContext custom = new CjmContext("custom/units");

        int testSize = 1_000_000;
        System.out.println("Going to invoke them all " + (testSize *8));
        long time = System.currentTimeMillis();
        List<Future<?>> results = new ArrayList<>();
        for (int i = 0; i < testSize; i++) {
            results.add(threadPool.submit((Callable<Object>) getPropsa));
            results.add(threadPool.submit(new ThreadedObjectInit(c, root)));
            results.add(threadPool.submit(new ThreadedObjectInit(c, unitsOrc)));
            results.add(threadPool.submit(new ThreadedObjectInit(c, custom)));
            results.add(threadPool.submit(new ThreadedObjectInit(s, root)));
            results.add(threadPool.submit((Callable<Object>) getPropsb));
            results.add(threadPool.submit(new ThreadedObjectInit(s, unitsOrc)));
            results.add(threadPool.submit(new ThreadedObjectInit(s, custom)));
            // if(i == 5000) dynProps.add(new CallableFunctor(refresher));
        }
        System.out.println("Done invoking");
        MockSingleton ms = null;
        int countChanges = 0;
        for (int i = 0; i < testSize*8; i += 8) {
            // if(i % 100 == 0) System.out.println("done: " + i);
            Properties propsa = (Properties) ((Future) results.get(i)).get();
            Properties propsb = (Properties) ((Future) results.get(i + 5))
                    .get();
            assertEquals("red", propsa
                    .getProperty("color"), "Failed at i = " + i);
            assertEquals("purple", propsb
                    .getProperty("color"), "Failed at i = " + i);
            if (ms == null) {
                ms = ((Future<BasicContextOriented>) results.get(i + 1)).get()
                        .getMyService();
            }
            if (ms != ((Future<BasicContextOriented>) results.get(i + 1)).get()
                    .getMyService()) {
                ms = ((Future<BasicContextOriented>) results.get(i + 1)).get()
                        .getMyService();
                countChanges++;
            }
            assertEquals(ms,
                    ((Future<BasicContextOriented>) results.get(i + 1)).get()
                            .getMyService());
            assertEquals("path1",
                    ((Future<BasicContextOriented>) results.get(i + 1)).get()
                            .getPaths()[0], "Failed at i = " + i);
            assertEquals("orc_path1",
                    ((Future<BasicContextOriented>) results.get(i + 2)).get()
                            .getPaths()[0], "Failed at i = " + i);
            assertEquals(ms,
                    ((Future<BasicContextOriented>) results.get(i + 2)).get()
                            .getMyService(), "Failed at i = " + i);
            assertEquals("custom/units/",
                    ((Future<BasicContextOriented>) results.get(i + 3)).get()
                            .getPaths()[0], "Failed at i = " + i);
            assertEquals(ms,
                    ((Future<BasicContextOriented>) results.get(i + 3)).get()
                            .getMyService(), "Failed at i = " + i);
            // if(i == 40000) i++;
        }
        ContextFactory.refresh(new CjmContext(""));
        // assertEquals(1,countChanges);
        System.out.println("Total Challenge time = "
                + (System.currentTimeMillis() - time));
        // }
    }

    @Test
    public void testConcurrency() throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        List<Callable<BasicContextOriented>> inits = new LinkedList<Callable<BasicContextOriented>>();
        Constructor<BasicContextOriented> c = BasicContextOriented.class
                .getConstructor(CjmContext.class);
        ExecutorService threadPool2 = Executors.newFixedThreadPool(20);
        List<Callable<SimpleContextOrientedB>> init2 = new LinkedList<Callable<SimpleContextOrientedB>>();
        Constructor<SimpleContextOrientedB> s = SimpleContextOrientedB.class
                .getConstructor(CjmContext.class);
        CjmContext root = new CjmContext();
        CjmContext unitsOrc = new CjmContext("units/orc");
        CjmContext custom = new CjmContext("custom/units");
        long time = System.currentTimeMillis();
        System.out.println(root.getName());
        for (int i = 0; i < 50000; i++) {
            inits.add(new ThreadedObjectInit<>(c, root));
            inits
                    .add(new ThreadedObjectInit<>(c,
                            unitsOrc));
            inits.add(new ThreadedObjectInit<>(c, custom));
            init2.add(new ThreadedObjectInit<>(s, root));
            init2.add(new ThreadedObjectInit<>(s, unitsOrc));
            init2
                    .add(new ThreadedObjectInit<>(s, custom));
        }
        List<Future<BasicContextOriented>> results = threadPool
                .invokeAll(inits);
        List<Future<SimpleContextOrientedB>> results2 = threadPool2
                .invokeAll(init2);
        MockSingleton ms = null;
        for (int i = 0; i < 150000; i += 3) {
            if (ms == null) {
                ms = results.get(i).get(10, TimeUnit.SECONDS).getMyService();
            }
            assertEquals(ms, results.get(i).get(10, TimeUnit.SECONDS).getMyService());
            assertEquals("path1", results.get(i).get(10, TimeUnit.SECONDS).getPaths()[0]);
            assertEquals("orc_path1", results.get(i + 1).get(10, TimeUnit.SECONDS).getPaths()[0]);
            assertEquals(ms, results.get(i + 1).get(10, TimeUnit.SECONDS).getMyService());
            assertEquals("custom/units/",
                    results.get(i + 2).get(10, TimeUnit.SECONDS).getPaths()[0]);
            assertEquals(ms, results.get(i + 2).get(10, TimeUnit.SECONDS).getMyService());
        }
        System.out.println("Total Concurrency time = "
                + (System.currentTimeMillis() - time));
    }

    @Test
    public void testDynamicConcurrency() throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        List<Callable<Properties>> dynProps = new LinkedList<Callable<Properties>>();
        Functor<Properties> getPropsa = new Functor(
                new AdvancedContextObject(), "getDynamicProperties");
        Functor<Properties> getPropsb = new Functor(new AdvancedContextObject(
                new CjmContext("custom")), "getDynamicProperties");

        long time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            dynProps.add(getPropsa);
            dynProps.add(getPropsb);
        }
        List<Future<Properties>> results = threadPool.invokeAll(dynProps);
        MockSingleton ms = null;
        for (int i = 0; i < 25000; i += 2) {
            Properties propsa = results.get(i).get();
            Properties propsb = results.get(i + 1).get();
            assertEquals("red", propsa.getProperty("color"));
            assertEquals("purple", propsb.getProperty("color"));
        }
        System.out.println("Total time(Dynamic Concurrency) = "
                + (System.currentTimeMillis() - time));
    }

    @Test
    public void testRefreshMemoryPerformance() throws Exception {
        MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
        long memUsed = 0;
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            createEverything();
            if (memUsed == 0) {
                memory.gc();
                Thread.sleep(20);
                memUsed = (long) (memory.getHeapMemoryUsage().getUsed() * 1.02);
            } else {
                memory.gc();
                Thread.sleep(20);
                assertTrue(memUsed > memory.getHeapMemoryUsage().getUsed(), "Some memory leakage on iteration " + i
                        + " memUsed =  " + memUsed + " current mem = "
                        + memory.getHeapMemoryUsage().getUsed());
            }
        }
        System.out.println("Time for each createEverything() = "
                + (System.currentTimeMillis() - time) / 1000);
    }

    @Test
    public void testDynamicPerformance() throws Exception {
        BasicContextOriented co = new BasicContextOriented(new CjmContext(
                "custom"));
        assertEquals("purple", co.getDynamicProperty("color"));
        BasicObject bo = new BasicObject();
        assertEquals("green", bo.getProperty("color"));
        long time = System.currentTimeMillis();
        System.out.println("weak objects = "
                +ContextFactory.getContextObjectCount());
        for (int i = 0; i < 1000000; i++) {
            assertEquals("purple", co.getDynamicProperty("color"));
        }
        System.out.println("Dynamic dependency time: "
                + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            assertEquals("green", bo.getProperty("color"));
        }
        System.out.println("normal dependency time: "
                + (System.currentTimeMillis() - time));

    }

    private void createEverything() {
        AdvancedContextObject aco = new AdvancedContextObject();
        BasicContextOriented bo = new BasicContextOriented();
        PerformanceTestObject pto = new PerformanceTestObject();
        SimpleContextOriented sco = new SimpleContextOriented();
        CyclicBasic cb = new CyclicBasic();
        SubContextOriented subco = new SubContextOriented();

        aco = new AdvancedContextObject(new CjmContext("config2"));
        bo = new BasicContextOriented(new CjmContext("config2"));
        pto = new PerformanceTestObject(new CjmContext("config2"));
        sco = new SimpleContextOriented(new CjmContext("config2"));
        cb = new CyclicBasic(new CjmContext("config2"));
        subco = new SubContextOriented(new CjmContext("config2"));

        aco = new AdvancedContextObject(new CjmContext("config3"));
        bo = new BasicContextOriented(new CjmContext("config3"));
        pto = new PerformanceTestObject(new CjmContext("config3"));
        sco = new SimpleContextOriented(new CjmContext("config3"));
        cb = new CyclicBasic(new CjmContext("config3"));
        subco = new SubContextOriented(new CjmContext("config3"));

        aco = new AdvancedContextObject(new CjmContext("custom"));
        bo = new BasicContextOriented(new CjmContext("custom"));
        pto = new PerformanceTestObject(new CjmContext("custom"));
        sco = new SimpleContextOriented(new CjmContext("custom"));
        cb = new CyclicBasic(new CjmContext("custom"));
        subco = new SubContextOriented(new CjmContext("custom"));

        aco = new AdvancedContextObject(new CjmContext("custom/units/orc"));
        bo = new BasicContextOriented(new CjmContext("custom/units/orc"));
        pto = new PerformanceTestObject(new CjmContext("custom/units/orc"));
        sco = new SimpleContextOriented(new CjmContext("custom/units/orc"));
        cb = new CyclicBasic(new CjmContext("custom/units/orc"));
        subco = new SubContextOriented(new CjmContext("custom/units/orc"));

        aco = new AdvancedContextObject(new CjmContext("custom/units/elf"));
        bo = new BasicContextOriented(new CjmContext("custom/units/elf"));
        pto = new PerformanceTestObject(new CjmContext("custom/units/elf"));
        sco = new SimpleContextOriented(new CjmContext("custom/units/elf"));
        cb = new CyclicBasic(new CjmContext("custom/units/elf"));
        subco = new SubContextOriented(new CjmContext("custom/units/elf"));

        aco = new AdvancedContextObject(new CjmContext("units/elf"));
        bo = new BasicContextOriented(new CjmContext("units/elf"));
        pto = new PerformanceTestObject(new CjmContext("units/elf"));
        sco = new SimpleContextOriented(new CjmContext("units/elf"));
        cb = new CyclicBasic(new CjmContext("units/elf"));
        subco = new SubContextOriented(new CjmContext("units/elf"));

        aco = new AdvancedContextObject(new CjmContext("override"));
        bo = new BasicContextOriented(new CjmContext("override"));
        pto = new PerformanceTestObject(new CjmContext("override"));
        sco = new SimpleContextOriented(new CjmContext("override"));
        cb = new CyclicBasic(new CjmContext("override"));
        subco = new SubContextOriented(new CjmContext("override"));

        aco = new AdvancedContextObject(new CjmContext("units"));
        bo = new BasicContextOriented(new CjmContext("units"));
        pto = new PerformanceTestObject(new CjmContext("units"));
        sco = new SimpleContextOriented(new CjmContext("units"));
        cb = new CyclicBasic(new CjmContext("units"));
        subco = new SubContextOriented(new CjmContext("units"));

        aco = new AdvancedContextObject(new CjmContext("custom/units"));
        bo = new BasicContextOriented(new CjmContext("custom/units"));
        pto = new PerformanceTestObject(new CjmContext("custom/units"));
        sco = new SimpleContextOriented(new CjmContext("custom/units"));
        cb = new CyclicBasic(new CjmContext("custom/units"));
        subco = new SubContextOriented(new CjmContext("custom/units"));

        aco = new AdvancedContextObject(new CjmContext("redirect"));
        bo = new BasicContextOriented(new CjmContext("redirect"));
        pto = new PerformanceTestObject(new CjmContext("redirect"));
        sco = new SimpleContextOriented(new CjmContext("redirect"));
        cb = new CyclicBasic(new CjmContext("redirect"));
        subco = new SubContextOriented(new CjmContext("redirect"));
    }

}
