package MultiThreading;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        Thread badThread = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("badThread has acquired lock.");
                Integer.parseInt("ac");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("badThread has released lock.");
            }

        });

        Thread goodThread = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("good thread has acquired lock.");
                Integer.parseInt("ac");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("goodThread has released lock.");
            }

        });

        badThread.start();
        goodThread.start();
        badThread.join();
        goodThread.join();
        System.out.println("Exiting Main.");
    }
}
