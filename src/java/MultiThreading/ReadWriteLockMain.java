package MultiThreading;

public class ReadWriteLockMain {

    public static void main(String[] args) throws InterruptedException {
        final ReadWriteLock rw1 = new ReadWriteLock();
        Thread writer1 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Attempting to acquire write lock in t1 : " + System.currentTimeMillis());
                    rw1.acquireWriteLock();
                    System.out.println("Write lock acquired at t1 : " + System.currentTimeMillis());
                    while (true) {
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread writer2 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Attempting to acquire write lock in t2 : " + System.currentTimeMillis());
                    rw1.acquireWriteLock();
                    System.out.println("Write lock acquired at t2 : " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread reader1 = new Thread() {
            @Override
            public void run() {
                try {
                    rw1.acquireReadLock();
                    System.out.println("Read lock acquired : " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread reader2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Read lock about  to release : " + System.currentTimeMillis());
                rw1.releaseReadLock();
                System.out.println("Read lock released at : " + System.currentTimeMillis());
            }
        };

        reader1.start();
        writer1.start();
        Thread.sleep(3000);
        reader2.start();
        Thread.sleep(1000);
        writer2.start();
        reader1.join();
        reader2.join();
        writer2.join();
    }
}

class ReadWriteLock {
    private int readers = 0;
    private boolean isWriteLocked = false;

    public synchronized void acquireReadLock() throws InterruptedException {
        while (isWriteLocked) {
            wait();
        }
        readers++;
    }

    public synchronized void releaseReadLock() {
        readers--;
        notify();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (isWriteLocked || readers != 0) {
            wait();
        }
        isWriteLocked = true;
    }

    public synchronized void releaseWriteLock() {
        isWriteLocked = false;
        notify();
    }
}
