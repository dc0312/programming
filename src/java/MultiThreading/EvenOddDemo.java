package MultiThreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddDemo {
    public static void main(String[] args) {
        Semaphore even = new Semaphore(1);
        Semaphore odd = new Semaphore(1);
        AtomicInteger i  = new AtomicInteger();
        Thread t1 = new Thread(()->{
            while (i.get()<10){
                try {
                    even.acquire();
                    System.out.println(i.getAndIncrement());
                    odd.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(()->{
            while (i.get()<10){
                try {
                    odd.acquire();
                    System.out.println(i.getAndIncrement());
                    even.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();
    }
}
