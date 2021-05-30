package MultiThreading;

public class DeadLockMain2 {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(
                () -> {
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + "got the lock1. Waiting for lock2...");
                        synchronized (lock2) {
                            System.out.println(Thread.currentThread().getName() + "got Lock 2...");
                        }
                        System.out.println("Exiting from " + Thread.currentThread().getName());
                    }
                }
        );
        Thread t2 = new Thread(
                () -> {
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + "got the lock2. Waiting for lock1...");
                        synchronized (lock1) {
                            System.out.println(Thread.currentThread().getName() + "got Lock 1...");
                        }
                        System.out.println("Exiting from " + Thread.currentThread().getName());
                    }
                }
        );
        t1.start();
        t2.start();
    }
}
