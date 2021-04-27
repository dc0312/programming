package MultiThreading;

import java.util.concurrent.Semaphore;

/*
This is a Semaphore bad code. In this code, we are not releasing the lock in finally block.
As in the program you can see that in badThread there is parsing exception due to which semaphore.release(); will not be reached.
Due to this the goodThread will not be able to get the lock. and It will cause a deadlock situation.
 */
public class SemaphoreBadMain {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Thread badThread = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("badThread has acquired lock.");
                Integer.parseInt("ac");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println("badThread has released lock.");
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
    }
}
