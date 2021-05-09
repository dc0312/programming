package MultiThreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PingPong {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore s1 = new Semaphore(1);
        final Semaphore s2 = new Semaphore(0);

        final AtomicInteger countDown = new AtomicInteger(10);
        Thread threadA = new Thread() {
            public void run() {
                try {
                    while (countDown.get() > 0) {
                        s1.acquire();

                        System.out.println("PING");

                        s2.release();

                        countDown.decrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread threadB = new Thread() {
            public void run() {
                try {
                    while (countDown.get() > 0) {
                        s2.acquire();

                        System.out.println("PONG");

                        s1.release();

                        countDown.decrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        threadA.start();
        threadB.start();


    }
}