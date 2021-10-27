package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadsDemoNew {
    private static volatile Integer threadIdToRun = 1;

    static class Printer implements Runnable {

        AtomicInteger i;
        Object lock;
        int threadNumber;

        public Printer(AtomicInteger i, Object lock, int threadNumber) {
            this.i = i;
            this.lock = lock;
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            while (i.get() < 20) {
                synchronized (lock) {
                    if (threadNumber != threadIdToRun) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " " + i.getAndIncrement());
                        if (threadNumber == 1) {
                            threadIdToRun = 2;
                        } else if (threadNumber == 2) {
                            threadIdToRun = 3;
                        } else if (threadNumber == 3) {
                            threadIdToRun = 1;
                        }
                        lock.notifyAll();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        Object lock = new Object();

        Thread t1 = new Thread(new Printer(i, lock, 1));
        Thread t2 = new Thread(new Printer(i, lock, 2));
        Thread t3 = new Thread(new Printer(i, lock, 3));

        t1.start();
        t2.start();
        t3.start();
    }
}
