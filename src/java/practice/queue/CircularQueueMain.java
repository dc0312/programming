package practice.queue;

class CircularQueue {
    int size, front, rear;

    int items[];

    CircularQueue(int size) {
        this.size = size;
        items = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return rear - front + 1 == 0 || rear - front + 1 == size;
    }

    public void insert(int data) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        if (isEmpty()) {
            front++;
        }
        if (rear == size - 1) {
            rear = -1;
        }
        items[++rear] = data;
    }

    public int delete() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int data = items[front];
        if (front == size - 1) {
            front = 0;
        } else if (rear == front) {
            rear = -1;
            front = -1;
        } else {
            front++;
        }


        return data;
    }

    public void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % size)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }

}

public class CircularQueueMain {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        System.out.println("Is empty ? " + circularQueue.isEmpty());
        System.out.println("Is Full ? " + circularQueue.isFull());
        circularQueue.display();
        circularQueue.insert(1);
        circularQueue.insert(2);
        circularQueue.insert(3);
        circularQueue.insert(4);
        circularQueue.insert(5);
        circularQueue.display();
        circularQueue.insert(6);
        circularQueue.delete();
        circularQueue.delete();
        System.out.println("Is Full ? " + circularQueue.isFull());
        circularQueue.insert(6);
        circularQueue.display();
        circularQueue.insert(7);
        System.out.println("------------------- 1");
        circularQueue.delete();
        circularQueue.display();
        System.out.println("------------------- 2");
        circularQueue.delete();
        circularQueue.display();
        System.out.println("------------------- 3");
        circularQueue.delete();
        circularQueue.display();
        System.out.println("------------------- 4");
        circularQueue.delete();
        circularQueue.display();
        System.out.println("------------------- 5");
        circularQueue.delete();
        circularQueue.display();
        System.out.println("------------------- 6");
    }
}
