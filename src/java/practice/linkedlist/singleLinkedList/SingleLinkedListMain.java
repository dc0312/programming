package practice.linkedlist.singleLinkedList;

class Link {
    Link next;
    int data;

    public Link(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Link{" +
                "link=" + next +
                ", data=" + data +
                '}';
    }

    public void displayLink() {
        System.out.print(data + "-->");
    }
}

class SingleLinkedList {
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
        if (isEmpty()) {
            System.out.println("Linked List is empty. Cannot delete.");
            return -1;
        }
        int data;
        if (size() == 1) {
            data = head.data;
            head = null;
            tail = null;
            counter--;
        } else {
            if (location >= size()) {
                location = -1;
            }
            if (location == 0) {
                data = head.data;
                head = head.next;
                counter--;
            } else if (location == -1) {
                Link tempLink = head;
                while (tempLink.next != tail) {
                    tempLink = tempLink.next;
                }
                data = tail.data;
                tail = tempLink;
                tempLink.next = null;
                counter--;
            } else {
                Link tempLink = head;
                int index = 0;
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
            System.out.println("Linked List is empty. Cannot display");
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

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.display();
        singleLinkedList.insert(2, 0);
        singleLinkedList.insert(1, 0);
        singleLinkedList.insert(4, -1);
        singleLinkedList.insert(5, 2);
        singleLinkedList.display();
        System.out.println("Item Deleted : " + singleLinkedList.delete(0));
        singleLinkedList.display();
        System.out.println();
        System.out.println("Item Deleted : " + singleLinkedList.delete(-1));
        singleLinkedList.display();
        System.out.println();
        System.out.println("Item Deleted : " + singleLinkedList.delete(2));
        singleLinkedList.display();
        System.out.println();
        System.out.println("Item Deleted : " + singleLinkedList.delete(-1));
        singleLinkedList.display();
        System.out.println();
        System.out.println("Item Deleted : " + singleLinkedList.delete(1));
        singleLinkedList.display();
        System.out.println();
    }
}
