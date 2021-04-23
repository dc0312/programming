package practice.queue;

class Link {
    int data;
    Link next;

    Link(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + "->");
    }
}

class LinkedList {
    Link head;
    Link tail;
    int counter;

    public boolean isEmpty() {
        return null == head;
    }

    public int size() {
        return counter;
    }

    public void insert(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
            counter++;
        } else {
            newLink.next = head;
            head = newLink;
            counter++;
        }
    }

    public int delete() {
        int data;
        if (isEmpty()) {
            System.out.println("Queue Is empty");
            return -1;
        } else if (size() == 1) {
            data = head.data;
            head = null;
            tail = null;
            counter--;
        } else {
            data = head.data;
            head = head.next;
            counter--;
        }
        return data;
    }

    public void display() {

        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

}

class Queue {
    LinkedList linkedList;

    Queue() {
        linkedList = new LinkedList();
    }

    public void enqueue(int data) {
        linkedList.insert(data);
    }

    public int dequeue() {
        return linkedList.delete();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }
        linkedList.display();
    }
}

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println("Queue Size : " + queue.size());
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.display();
        System.out.println("Queue Size : " + queue.size());
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
    }
}
