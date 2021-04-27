package MultiThreading;

public class DeadLockMain {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    DeadLock.increment();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    DeadLock.decrements();
                }
            }
        };
        t1.start();
        t2.start();
        t1.wait();
    }
}

class DeadLock {


    static Object lock1 = new Object();
    static Object lock2 = new Object();

    static int i = 0;

    public static void increment() {
        synchronized (lock1) {
            System.out.println("Acquire Lock 1. Waiting for Lock 2");
            synchronized (lock2) {
                System.out.println("Acquired Lock 2");
                i++;
            }
        }
    }

    public static void decrements() {
        synchronized (lock2) {
            System.out.println("Acquire Lock 2. Waiting for Lock 1");
            synchronized (lock1) {
                System.out.println("Acquired Lock 1");
                i++;
            }
        }
    }

}
