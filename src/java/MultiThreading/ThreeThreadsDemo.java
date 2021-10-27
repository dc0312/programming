package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadsDemo {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        Object lock = new Object();
        MyThread1 t1 = new MyThread1(i, lock);
        MyThread2 t2 = new MyThread2(i, lock);
        MyThread3 t3 = new MyThread3(i, lock);

        t1.start();
        t2.start();
        t3.start();
    }

    static class MyThread1 extends Thread {
        AtomicInteger i;
        Object lock;

        MyThread1(AtomicInteger i, Object lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (i.get() < 10) {
                    while (i.get() % 3 == 0 || i.get() % 3 == 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i.getAndIncrement());
                    lock.notifyAll();
                }
            }
        }
    }

    static class MyThread2 extends Thread {
        AtomicInteger i;
        Object lock;

        MyThread2(AtomicInteger i, Object lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (i.get() < 10) {
                    while ((i.get() % 3 == 0 || i.get() % 3 == 1)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i.getAndIncrement());
                    lock.notifyAll();
                }
            }
        }
    }

    static class MyThread3 extends Thread {
        AtomicInteger i;
        Object lock;

        MyThread3(AtomicInteger i, Object lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (i.get() < 10) {
                    while (i.get() % 3 == 1 ||  i.get() % 3 == 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i.getAndIncrement());
                    lock.notifyAll();
                }
            }
        }
    }
}
