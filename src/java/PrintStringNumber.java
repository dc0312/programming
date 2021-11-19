import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PrintStringNumber {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {

            while (atomicInteger.get() < 10) {
                lock.lock();
                if (atomicBoolean.get() == true) {
                    System.out.println("Deepak");
                    atomicBoolean.set(false);
                }
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {

            while (atomicInteger.get() < 10) {
                lock.lock();

                if (atomicBoolean.get() == false) {
                    System.out.println(atomicInteger.getAndIncrement());
                    atomicBoolean.set(true);
                }
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
