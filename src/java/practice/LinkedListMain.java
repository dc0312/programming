package practice;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.insertFirst(3);
        integerLinkedList.insertFirst(2);
        integerLinkedList.insertFirst(1);
        integerLinkedList.display();
        integerLinkedList.insertLast(4);
        integerLinkedList.display();
    }

    static class Link<T> {
        T data;
        Link next;

        Link(T data) {
            this.data = data;
        }

        public void displayLink() {
            System.out.print(data + "->");
        }
    }

    static class LinkedList<T> {
        int counter;
        Link head;
        Link tail;

        public boolean isEmpty() {
            return null == head;
        }

        public int size() {
            return counter;
        }

        public void insertFirst(T data) {
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

        public void insertLast(T data) {
            Link newLink = new Link(data);
            if (isEmpty()) {
                head = newLink;
                tail = newLink;
                counter++;
            } else {
                tail.next = newLink;
                tail = newLink;
                counter++;
            }
        }

        public void display() {
            Link current = head;
            while (null != current) {
                current.displayLink();
                current = current.next;
            }
            System.out.println();
        }
    }

}
