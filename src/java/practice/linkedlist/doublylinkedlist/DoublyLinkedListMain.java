package practice.linkedlist.doublylinkedlist;

class Link {
    Link next;
    Link prev;
    int data;

    public Link(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + "-->");
    }
}

class DoublyLinkedList {
    Link head;
    Link tail;
    int counter;

    public boolean isEmpty() {
        return null == head;
    }

    public int size() {
        return counter;
    }

    public void insert(int data, int location) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
            counter++;
        } else {
            if (location >= size()) {
                location = -1;
            }
            if (location == 0) {
                newLink.next = head;
                head = newLink;
                counter++;
            } else if (location == -1) {
                tail.next = newLink;
                newLink.prev = tail;
                tail = newLink;
                counter++;
            } else {
                Link tempLink = head;
                int index = 0;
                while (index < location - 1) {
                    tempLink = tempLink.next;
                    index++;
                }
                newLink.next = tempLink.next;
                tempLink.next.prev = newLink;
                newLink.prev = tempLink;
                tempLink.next = newLink;
                counter++;

            }
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked List is empty.");
            return;
        }
        Link tempLink = head;
        while (null != tempLink) {
            tempLink.displayLink();
            tempLink = tempLink.next;
        }
        System.out.println();
    }
}

public class DoublyLinkedListMain {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.display();
        doublyLinkedList.insert(2, 0);
        doublyLinkedList.insert(1, 0);
        doublyLinkedList.insert(4, -1);
        doublyLinkedList.insert(5, 10);
        doublyLinkedList.insert(3, 2);
        doublyLinkedList.display();
        System.out.println();
    }
}
