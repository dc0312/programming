package practice.stack;

class Stack {
    class Link {
        int data;
        Link next;
        Link oldMin;

        Link(int data) {
            this.data = data;
        }

        public void displayLink() {
            System.out.print(data + "->");
        }
    }

    Link head;
    Link tail;
    int counter;
    Link min;

    public boolean isEmpty() {
        return null == head;
    }

    public int getSize() {
        return counter;
    }

    public int min() {
        return min.data;
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
        if (null == min || newLink.data < min.data) {
            newLink.oldMin = min;
            min = newLink;
        }
    }

    public int delete() {
        int data = -1;
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            Link tempLink = head;
            data = tempLink.data;
            head = tempLink.next;
            if (tempLink.oldMin != null) {
                min = tempLink.oldMin;
            }
            counter--;
        }
        return data;
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

public class StackMin {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Is empty ? " + stack.isEmpty());
        System.out.println("Size :  " + stack.getSize());
        stack.insert(4);
        stack.insert(2);
        stack.insert(1);
        stack.insert(3);
        System.out.println("Size :  " + stack.getSize());
        stack.display();
        System.out.println("Min data : " + stack.min());
        System.out.println("Item Deleted : " + stack.delete());
        System.out.println("Item Deleted : " + stack.delete());
        stack.display();
        System.out.println("Min data : " + stack.min());
    }
}
