package MultiThreading;

class BlockingQueue<T> {
    //This will tell us the size of the queue which it can have at max.
    int capacity;
    int head = 0;
    int tail = 0;
    //This tell the current size of the queue.
    int size = 0;
    T[] array;

    BlockingQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        //Wait for queue to have space.
        while (size == capacity) {
            System.out.println("Size full..Wait for dequeue.");
            wait();
        }

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

    }

    public synchronized T dequeue() throws InterruptedException {
        //Wait for at least one item to be enqueued.
        while (size == 0) {
            System.out.println("Queue Empty..Wait for enqueue.");
            wait();
        }

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
        return item;
    }

}

public class BlockingQueueMain {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.enqueue(i);
                    System.out.println("Item enqueued : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Item dequeued by t2: " + queue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
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
