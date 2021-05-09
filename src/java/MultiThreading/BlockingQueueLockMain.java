package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

class BlockingQueueLock<T> {
    //This will tell us the size of the queue which it can have at max.
    int capacity;
    int head = 0;
    int tail = 0;
    //This tell the current size of the queue.
    int size = 0;
    ReentrantLock lock;
    T[] array;

    BlockingQueueLock(int capacity, ReentrantLock reentrantLock) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        this.lock = reentrantLock;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        //Wait for queue to have space.
        while (size == capacity) {
            System.out.println("Size full..Wait for dequeue.");
            wait();
        }
        lock.lock();
        //reset tail to the begining if the tail is already at the end of the backing array.
        if (tail == capacity) {
            tail = 0;
        }

        //Place the item in the array.
        array[tail] = item;
        tail++;
        size++;

        //Don't forget to notify any other threads waiting on a change in the value of size
        //There might be consumers waiting for the queue to have at least one element.
        notifyAll();
        lock.unlock();
        ;
    }

    public synchronized T dequeue() throws InterruptedException {
        //Wait for at least one item to be enqueued.
        while (size == 0) {
            System.out.println("Queue Empty..Wait for enqueue.");
            wait();
        }
        lock.lock();
        //reset head to start of array if its past the array.
        if (head == capacity) {
            head = 0;
        }

        //Store the reference to the object being dequeued and overwrite with null
        T item = array[head];
        head++;
        size--;

        //Don't forget to call notify, there might be another thread blocked in the enqueue method.
        notifyAll();
        lock.unlock();
        return item;
    }

}

public class BlockingQueueLockMain {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        BlockingQueueLock<Integer> queue = new BlockingQueueLock<>(5, reentrantLock);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    queue.enqueue(i);
                    System.out.println("Item enqueued : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println("Item dequeued by t2: " + queue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    System.out.println("Item dequeued by t3: " + queue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
