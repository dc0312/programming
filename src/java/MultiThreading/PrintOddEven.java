package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEven {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger num = new AtomicInteger(1);
        Thread oddThread = new Thread(() -> {

            for (int i = 0; num.get() < 10; i++) {
                lock.lock();
                if (num.get() % 2 != 0) {
                    System.out.println(num.getAndIncrement());
                    //num.getAndIncrement();
                }

                lock.unlock();

            }

        });

        Thread evenThread = new Thread(() -> {

            for (int i = 0; num.get() < 10; i++) {
                lock.lock();
                if (num.get() % 2 == 0) {
                    System.out.println(num.getAndIncrement());
                    //num.getAndIncrement();
                }

                lock.unlock();
            }

        });

        oddThread.start();
        evenThread.start();


    }
}
