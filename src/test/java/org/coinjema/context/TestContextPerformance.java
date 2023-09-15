package org.coinjema.context;

import org.coinjema.nontest.*;
import org.coinjema.util.Functor;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestContextPerformance extends AbstractContextTester {
    String[] paths = new String[]{"path1", "path2"};
    CoinjemaContext[] contexts = new CoinjemaContext[]{new CoinjemaContext(),
            new CoinjemaContext("config2"), new CoinjemaContext("custom"),
            new CoinjemaContext("custom/units"),
            new CoinjemaContext("custom/units/elf"),
            new CoinjemaContext("custom/units/orc"),
            new CoinjemaContext("override"), new CoinjemaContext("units"),
            new CoinjemaContext("units/elf"), new CoinjemaContext("units/orc")};
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
                + SpiceRack.contextObjects.map.size());
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
                + SpiceRack.contextObjects.map.size());

        System.gc();
        Thread.currentThread().sleep(100);
        System.out.println("AOP Time = " + aopTime);
        System.out.println("Normal Time = " + normalTime);
        // assertTrue(aopTime / normalTime <= 50);

        System.out.println("Saved objects = "
                + SpiceRack.contextObjects.map.size());

    }

    @Test
    public void testTheConcurrencyChallenge() throws Exception {
        // for(int j = 0;j < 50;j++) {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        List dynProps = new LinkedList();
        Functor getPropsa = new Functor(new AdvancedContextObject(),
                "getDynamicProperties");
        Functor getPropsb = new Functor(new AdvancedContextObject(
                new CoinjemaContext("custom")), "getDynamicProperties");
        Functor refresher = new Functor(SpiceRack.root, "refresh");
        List inits = new LinkedList();
        Constructor c = BasicContextOriented.class
                .getConstructor(CoinjemaContext.class);
        List init2 = new LinkedList();
        Constructor s = SimpleContextOrientedB.class
                .getConstructor(CoinjemaContext.class);
        CoinjemaContext root = new CoinjemaContext();
        CoinjemaContext unitsOrc = new CoinjemaContext("units/orc");
        CoinjemaContext custom = new CoinjemaContext("custom/units");

        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            dynProps.add(getPropsa);
            dynProps.add(new ThreadedObjectInit(c, root));
            dynProps.add(new ThreadedObjectInit(c, unitsOrc));
            dynProps.add(new ThreadedObjectInit(c, custom));
            dynProps.add(new ThreadedObjectInit(s, root));
            dynProps.add(getPropsb);
            dynProps.add(new ThreadedObjectInit(s, unitsOrc));
            dynProps.add(new ThreadedObjectInit(s, custom));
            // if(i == 5000) dynProps.add(new CallableFunctor(refresher));
        }
        System.out.println("Going to invoke them all " + dynProps.size());
        List results = threadPool.invokeAll(dynProps);
        System.out.println("Done invoking");
        MockSingleton ms = null;
        int countChanges = 0;
        for (int i = 0; i < 80000; i += 8) {
            // if(i % 100 == 0) System.out.println("done: " + i);
            Properties propsa = (Properties) ((Future) results.get(i)).get();
            Properties propsb = (Properties) ((Future) results.get(i + 5))
                    .get();
            assertEquals( "red", propsa
                    .getProperty("color"),"Failed at i = " + i);
            assertEquals( "purple", propsb
                    .getProperty("color"),"Failed at i = " + i);
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
            assertEquals( "path1",
                    ((Future<BasicContextOriented>) results.get(i + 1)).get()
                            .getPaths()[0],"Failed at i = " + i);
            assertEquals( "orc_path1",
                    ((Future<BasicContextOriented>) results.get(i + 2)).get()
                            .getPaths()[0],"Failed at i = " + i);
            assertEquals( ms,
                    ((Future<BasicContextOriented>) results.get(i + 2)).get()
                            .getMyService(),"Failed at i = " + i);
            assertEquals( "custom/units/",
                    ((Future<BasicContextOriented>) results.get(i + 3)).get()
                            .getPaths()[0],"Failed at i = " + i);
            assertEquals( ms,
                    ((Future<BasicContextOriented>) results.get(i + 3)).get()
                            .getMyService(),"Failed at i = " + i);
            // if(i == 40000) i++;
        }
        ContextFactory.refresh(new CoinjemaContext(""));
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
                .getConstructor(CoinjemaContext.class);
        ExecutorService threadPool2 = Executors.newFixedThreadPool(20);
        List<Callable<SimpleContextOrientedB>> init2 = new LinkedList<Callable<SimpleContextOrientedB>>();
        Constructor<SimpleContextOrientedB> s = SimpleContextOrientedB.class
                .getConstructor(CoinjemaContext.class);
        CoinjemaContext root = new CoinjemaContext();
        CoinjemaContext unitsOrc = new CoinjemaContext("units/orc");
        CoinjemaContext custom = new CoinjemaContext("custom/units");
        long time = System.currentTimeMillis();
        System.out.println(root.getName());
        for (int i = 0; i < 50000; i++) {
            inits.add(new ThreadedObjectInit<BasicContextOriented>(c, root));
            inits
                    .add(new ThreadedObjectInit<BasicContextOriented>(c,
                            unitsOrc));
            inits.add(new ThreadedObjectInit<BasicContextOriented>(c, custom));
            init2.add(new ThreadedObjectInit<SimpleContextOrientedB>(s, root));
            init2.add(new ThreadedObjectInit<SimpleContextOrientedB>(s,
                    unitsOrc));
            init2
                    .add(new ThreadedObjectInit<SimpleContextOrientedB>(s,
                            custom));
        }
        List<Future<BasicContextOriented>> results = threadPool
                .invokeAll(inits);
        List<Future<SimpleContextOrientedB>> results2 = threadPool2
                .invokeAll(init2);
        MockSingleton ms = null;
        for (int i = 0; i < 150000; i += 3) {
            if (ms == null) {
                ms = results.get(i).get().getMyService();
            }
            assertEquals(ms, results.get(i).get().getMyService());
            assertEquals("path1", results.get(i).get().getPaths()[0]);
            assertEquals("orc_path1", results.get(i + 1).get().getPaths()[0]);
            assertEquals(ms, results.get(i + 1).get().getMyService());
            assertEquals("custom/units/",
                    results.get(i + 2).get().getPaths()[0]);
            assertEquals(ms, results.get(i + 2).get().getMyService());
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
                new CoinjemaContext("custom")), "getDynamicProperties");

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
        BasicContextOriented co = new BasicContextOriented(new CoinjemaContext(
                "custom"));
        assertEquals("purple", co.getDynamicProperty("color"));
        BasicObject bo = new BasicObject();
        assertEquals("green", bo.getProperty("color"));
        long time = System.currentTimeMillis();
        System.out.println("weak objects = "
                + SpiceRack.contextObjects.map.size());
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

        aco = new AdvancedContextObject(new CoinjemaContext("config2"));
        bo = new BasicContextOriented(new CoinjemaContext("config2"));
        pto = new PerformanceTestObject(new CoinjemaContext("config2"));
        sco = new SimpleContextOriented(new CoinjemaContext("config2"));
        cb = new CyclicBasic(new CoinjemaContext("config2"));
        subco = new SubContextOriented(new CoinjemaContext("config2"));

        aco = new AdvancedContextObject(new CoinjemaContext("config3"));
        bo = new BasicContextOriented(new CoinjemaContext("config3"));
        pto = new PerformanceTestObject(new CoinjemaContext("config3"));
        sco = new SimpleContextOriented(new CoinjemaContext("config3"));
        cb = new CyclicBasic(new CoinjemaContext("config3"));
        subco = new SubContextOriented(new CoinjemaContext("config3"));

        aco = new AdvancedContextObject(new CoinjemaContext("custom"));
        bo = new BasicContextOriented(new CoinjemaContext("custom"));
        pto = new PerformanceTestObject(new CoinjemaContext("custom"));
        sco = new SimpleContextOriented(new CoinjemaContext("custom"));
        cb = new CyclicBasic(new CoinjemaContext("custom"));
        subco = new SubContextOriented(new CoinjemaContext("custom"));

        aco = new AdvancedContextObject(new CoinjemaContext("custom/units/orc"));
        bo = new BasicContextOriented(new CoinjemaContext("custom/units/orc"));
        pto = new PerformanceTestObject(new CoinjemaContext("custom/units/orc"));
        sco = new SimpleContextOriented(new CoinjemaContext("custom/units/orc"));
        cb = new CyclicBasic(new CoinjemaContext("custom/units/orc"));
        subco = new SubContextOriented(new CoinjemaContext("custom/units/orc"));

        aco = new AdvancedContextObject(new CoinjemaContext("custom/units/elf"));
        bo = new BasicContextOriented(new CoinjemaContext("custom/units/elf"));
        pto = new PerformanceTestObject(new CoinjemaContext("custom/units/elf"));
        sco = new SimpleContextOriented(new CoinjemaContext("custom/units/elf"));
        cb = new CyclicBasic(new CoinjemaContext("custom/units/elf"));
        subco = new SubContextOriented(new CoinjemaContext("custom/units/elf"));

        aco = new AdvancedContextObject(new CoinjemaContext("units/elf"));
        bo = new BasicContextOriented(new CoinjemaContext("units/elf"));
        pto = new PerformanceTestObject(new CoinjemaContext("units/elf"));
        sco = new SimpleContextOriented(new CoinjemaContext("units/elf"));
        cb = new CyclicBasic(new CoinjemaContext("units/elf"));
        subco = new SubContextOriented(new CoinjemaContext("units/elf"));

        aco = new AdvancedContextObject(new CoinjemaContext("override"));
        bo = new BasicContextOriented(new CoinjemaContext("override"));
        pto = new PerformanceTestObject(new CoinjemaContext("override"));
        sco = new SimpleContextOriented(new CoinjemaContext("override"));
        cb = new CyclicBasic(new CoinjemaContext("override"));
        subco = new SubContextOriented(new CoinjemaContext("override"));

        aco = new AdvancedContextObject(new CoinjemaContext("units"));
        bo = new BasicContextOriented(new CoinjemaContext("units"));
        pto = new PerformanceTestObject(new CoinjemaContext("units"));
        sco = new SimpleContextOriented(new CoinjemaContext("units"));
        cb = new CyclicBasic(new CoinjemaContext("units"));
        subco = new SubContextOriented(new CoinjemaContext("units"));

        aco = new AdvancedContextObject(new CoinjemaContext("custom/units"));
        bo = new BasicContextOriented(new CoinjemaContext("custom/units"));
        pto = new PerformanceTestObject(new CoinjemaContext("custom/units"));
        sco = new SimpleContextOriented(new CoinjemaContext("custom/units"));
        cb = new CyclicBasic(new CoinjemaContext("custom/units"));
        subco = new SubContextOriented(new CoinjemaContext("custom/units"));

        aco = new AdvancedContextObject(new CoinjemaContext("redirect"));
        bo = new BasicContextOriented(new CoinjemaContext("redirect"));
        pto = new PerformanceTestObject(new CoinjemaContext("redirect"));
        sco = new SimpleContextOriented(new CoinjemaContext("redirect"));
        cb = new CyclicBasic(new CoinjemaContext("redirect"));
        subco = new SubContextOriented(new CoinjemaContext("redirect"));
    }

}
