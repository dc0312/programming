package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class PingPongDemo {

    static class Ping extends Thread {
        AtomicInteger i;
        Object lock;

        Ping(AtomicInteger i, Object lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                while (i.get() < 10) {
                    while (i.get() % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i.getAndIncrement();
                    System.out.println("Ping");
                    lock.notify();
                }
            }
        }
    }

    static class Pong extends Thread {
        AtomicInteger i;
        Object lock;

        Pong(AtomicInteger i, Object lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                while (i.get() < 10) {
                    while (i.get() % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i.getAndIncrement();
                    System.out.println("Pong");
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        Object lock = new Object();
        Ping ping = new Ping(i, lock);
        Pong pong = new Pong(i, lock);
        ping.start();
        pong.start();
    }
}
