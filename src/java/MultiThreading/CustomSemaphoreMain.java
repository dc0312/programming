package MultiThreading;


import java.util.concurrent.atomic.AtomicInteger;

class CustomSemaphore {
    int maxPermits;
    int usedPermits;

    CustomSemaphore(int maxPermits) {
        this.maxPermits = maxPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (maxPermits == usedPermits) {
            this.wait();
        }
        usedPermits++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits < 0) {
            this.wait();
        }

        usedPermits--;
        notify();
    }
}

public class CustomSemaphoreMain {
    public static void main(String[] args) {
        final CustomSemaphore s1 = new CustomSemaphore(1);
        final CustomSemaphore s2 = new CustomSemaphore(0);

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
