package MultiThreading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class IntegerThread extends Thread {
    private AtomicInteger i;
    private ReentrantLock lock;
    private AtomicBoolean atomicBoolean;

    IntegerThread(AtomicInteger i, ReentrantLock lock, AtomicBoolean atomicBoolean) {
        this.i = i;
        this.lock = lock;
        this.atomicBoolean = atomicBoolean;
    }

    @Override
    public void run() {
        while (i.get() < 10) {
            lock.lock();
            if (atomicBoolean.get()) {
                System.out.print(i.getAndIncrement());
                atomicBoolean.set(false);
            }
            lock.unlock();
        }

    }
}

class StringThread extends Thread {
    private AtomicInteger i;
    private ReentrantLock lock;
    private AtomicBoolean atomicBoolean;

    StringThread(AtomicInteger i, ReentrantLock lock, AtomicBoolean atomicBoolean) {
        this.i = i;
        this.lock = lock;
        this.atomicBoolean = atomicBoolean;
    }

    @Override
    public void run() {
        while (i.get() < 10) {
            lock.lock();
            if (!atomicBoolean.get()) {
                System.out.print("Shubham");
                atomicBoolean.set(true);
            }
            lock.unlock();
        }

    }
}

public class PrintStringNumber {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger i = new AtomicInteger(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        IntegerThread intThread = new IntegerThread(i, lock, atomicBoolean);
        StringThread str = new StringThread(i, lock, atomicBoolean);
        intThread.start();
        str.start();
    }
}
