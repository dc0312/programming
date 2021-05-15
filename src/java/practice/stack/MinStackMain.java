package practice.stack;


public class MinStackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        System.out.println("Min : " + stack.min());
        stack.pop();
        stack.pop();
        System.out.println("Min : " + stack.min());
        stack.pop();
        System.out.println("Min : " + stack.min());
        stack.pop();
        System.out.println("Min : " + stack.min());

    }

    private static class Stack {
        Link head;

        public boolean isEmpty() {
            return null == head;
        }

        public void push(int data) {
            Link newLink = new Link(data);
            if (!isEmpty()) {
                int min = head.min;
                min = Math.min(min, data);
                newLink.min = min;
                newLink.next = head;
            }
            head = newLink;
        }

        public void pop() {
            if (isEmpty()) {
                return;
            }
            head = head.next;
        }

        public int top() {
            return head.data;
        }

        public int min() {
            if (isEmpty()) {
                return -1;
            }
            return head.min;
        }

        private static class Link {
            int data;
            int min;
            Link next;

            Link(int data) {
                this.data = data;
                min = data;
            }
        }

    }
}
