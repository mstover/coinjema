package org.coinjema.testing.util;

import org.coinjema.cjm.util.StateBox;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class StateBoxTests {

    @Test
    public void concurrentTest() throws InterruptedException {
        StateBox<Long> timerBox = new StateBox<>() {
            private long startTime = System.currentTimeMillis();

            @Override
            protected Long internalGet() {
                return System.currentTimeMillis() - startTime;
            }
        };

        StateBox<Float> speed = new StateBox<>(timerBox) {

            @Override
            protected Float internalGet() {
                Long time = timerBox.get();
                if (time < 5000) {
                    return 1.1f + time / 5000f;
                } else if (time < 20000) {
                    return 2.3f + time / 12000f;
                } else {
                    return 4.9f + time / 40000f;
                }
            }
        };

        StateBox<Float> distance1 = new StateBox<Float>(timerBox, speed) {
            private float dist = 0f;
            private long prevTime = 0l;

            @Override
            protected Float internalGet() {
                Long l = timerBox.get();
                dist += (l - prevTime) * speed.get();
                prevTime = l;
                return dist;
            }
        };
        StateBox<Float> distance2 = new StateBox<Float>(timerBox, speed) {
            private float dist = 0f;
            private long prevTime = 0l;

            @Override
            protected Float internalGet() {
                Long l = timerBox.get();
                dist += (l - prevTime) * speed.get();
                prevTime = l;
                return dist;
            }
        };
        StateBox<Integer> counter = new StateBox<Integer>(distance1) {
            private int count = 0;

            @Override
            protected Integer internalGet() {
                return ++count;
            }
        };
        boolean[] done = new boolean[]{false};
        Thread.Builder.OfVirtual timerThread1 = Thread.ofVirtual();
        Thread.Builder.OfVirtual timerThread2 = Thread.ofVirtual();
        Thread.Builder.OfVirtual distThread1a = Thread.ofVirtual();
        Thread.Builder.OfVirtual distThread1b = Thread.ofVirtual();
        Thread.Builder.OfVirtual distThread2b = Thread.ofVirtual();
        StringBuffer buf = new StringBuffer();
        Thread.ofVirtual().start(() -> {
            while (!done[0]) {
                buf.append("\ncount = " + counter.get());
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timerThread2.start(() -> {
            while (!done[0]) {
                timerBox.markDirty();
            }
        });
        distThread1a.start(() -> {
            while (!done[0]) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Float dist = distance1.get();
                long time = timerBox.get();
                buf.append("\nd1a - time: " + time + " dist: " + dist);
            }
        });
        distThread1b.start(() -> {
            while (!done[0]) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Float dist = distance2.get();
                long time = timerBox.get();
                buf.append("\nd1b - time: " + time + " dist: " + dist);
            }
        });
        Thread.Builder.OfVirtual distThread2a = Thread.ofVirtual();
        distThread2a.start(() -> {
            while (!done[0]) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Float dist = distance1.get();
                long time = timerBox.get();
                buf.append("\nd2a - time: " + time + " dist: " + dist);
            }
        });distThread2b.start(() -> {
            while (!done[0]) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Float dist = distance2.get();
                long time = timerBox.get();
                buf.append("\nd2b - time: " + time + " dist: " + dist);
            }
        });
        timerThread1.start(() -> {
            while (!done[0]) {
                timerBox.markDirty();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        CountDownLatch latch = new CountDownLatch(1);
        Thread.ofVirtual().start(() -> {
            while (!done[0]) {
                if (timerBox.get() > 100_000l) {
                    done[0] = true;
                }
                System.out.println(buf.toString());
                buf.delete(0, buf.length());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (done[0]) {
                    latch.countDown();
                }
            }
        });
        latch.await();
    }
}
