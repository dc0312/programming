package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ReadWriteLockMultipleReaders {

    public static void main(String[] args) {
        AtomicInteger readerCount = new AtomicInteger();
        final ReadWriteLockWithMultipleReader rw1 = new ReadWriteLockWithMultipleReader(readerCount);
        Thread reader1 = new Thread(() -> {
            try {
                rw1.acquireReadLock();
                System.out.println("Reader 1 acquired read lock.");
                System.out.println("Reader 1 reading ...");
                Thread.sleep(5000);
                rw1.releaseReadLock();
                System.out.println("Reader 1 released the lock.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread reader2 = new Thread(() -> {
            try {
                rw1.acquireReadLock();
                System.out.println("Reader 2 acquired read lock.");
                System.out.println("Reader 2 reading ...");
                Thread.sleep(5000);
                rw1.releaseReadLock();
                System.out.println("Reader 2 released the lock.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread reader3 = new Thread(() -> {
            try {
                rw1.acquireReadLock();
                System.out.println("Reader 3 acquired read lock.");
                System.out.println("Reader 3 reading ...");
                Thread.sleep(5000);
                rw1.releaseReadLock();
                System.out.println("Reader 3 released the lock.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread reader4 = new Thread(() -> {
            try {
                rw1.acquireReadLock();
                System.out.println("Reader 4 acquired read lock.");
                System.out.println("Reader 4 reading ...");
                Thread.sleep(5000);
                rw1.releaseReadLock();
                System.out.println("Reader 4 released the lock.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread writer1 = new Thread(() -> {
            try {
                rw1.acquireWriteLock();
                System.out.println("Writer 1 acquired write lock.");
                System.out.println("Writer 1 writing ...");
                Thread.sleep(5000);
                rw1.releaseWriteLock();
                System.out.println("Writer 1 released the lock.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread writer2 = new Thread(() -> {
            try {
                rw1.acquireWriteLock();
                System.out.println("Writer 2 acquired write lock.");
                System.out.println("Writer 2 writing ...");
                Thread.sleep(5000);
                rw1.releaseWriteLock();
                System.out.println("Writer 2 released the lock.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();

        writer1.start();
        writer2.start();
    }

}

class ReadWriteLockWithMultipleReader {
    AtomicInteger numberOfReaders;
    boolean isWriteLocked;

    ReadWriteLockWithMultipleReader(AtomicInteger numberOfReaders) {
        this.numberOfReaders = numberOfReaders;
    }

    public synchronized void acquireReadLock() throws InterruptedException {
        while (numberOfReaders.get() > 1 || isWriteLocked) {
            wait();
        }
        numberOfReaders.getAndIncrement();
        notify();
    }

    public synchronized void releaseReadLock() {
        numberOfReaders.getAndDecrement();
        notify();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (numberOfReaders.get() != 0 || isWriteLocked) {
            wait();
        }
        isWriteLocked = true;
        notify();
    }

    public synchronized void releaseWriteLock() {
        isWriteLocked = false;
        notify();
    }

}
