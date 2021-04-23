package practice.linkedlist.circularLinkedList;

class Link {
    Link next;
    int data;

    public Link(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + "-->");
    }
}

class CircularLinkedList {
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
            newLink.next = head;
            counter++;
        } else {
            if (location >= size()) {
                location = -1;
            }
            if (location == 0) {
                newLink.next = head;
                head = newLink;
                tail.next = newLink;
                counter++;
            } else if (location == -1) {
                newLink.next = tail.next;
                tail.next = newLink;
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
                tempLink.next = newLink;
                counter++;
            }
        }
    }

    public int delete(int location) {
        int data = 0;
        if (size() == 1) {
            data = head.data;
            head = null;
            tail = null;
            counter--;
        } else {
            if (location >= size() - 1) {
                location = -1;
            }
            if (location == 0) {
                data = head.data;
                head = head.next;
                tail.next = head;
                counter--;
            } else if (location == -1) {
                Link tempLink = head;
                while (tempLink.next != tail) {
                    tempLink = tempLink.next;
                }
                data = tail.data;
                tail = tempLink;
                tail.next = head;
                counter--;
            } else {
                int index = 0;
                Link tempLink = head;
                while (index < location - 1) {
                    tempLink = tempLink.next;
                    index++;
                }
                data = tempLink.next.data;
                tempLink.next = tempLink.next.next;
                counter--;
            }
        }
        return data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty.");
            return;
        }
        Link tempLink = head;
        while (true) {
            tempLink.displayLink();
            tempLink = tempLink.next;
            if (tempLink == head) {
                break;
            }

        }
        System.out.println();
    }
}

public class CircularLinkedListMain {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.display();
        circularLinkedList.insert(2, 0);
        circularLinkedList.insert(1, 0);
        circularLinkedList.insert(4, -1);
        circularLinkedList.insert(5, 10);
        circularLinkedList.insert(7, 10);
        circularLinkedList.insert(6, 3);
        circularLinkedList.insert(3, 1);
        circularLinkedList.display();
        System.out.println();
        System.out.println("Item deleted : " + circularLinkedList.delete(0));
        circularLinkedList.display();
        System.out.println();
        System.out.println("Item deleted : " + circularLinkedList.delete(-1));
        circularLinkedList.display();
        System.out.println();
        System.out.println("Item deleted : " + circularLinkedList.delete(2));
        circularLinkedList.display();
        System.out.println();
        System.out.println("Item deleted : " + circularLinkedList.delete(12));
        circularLinkedList.display();
        System.out.println();
    }
}
