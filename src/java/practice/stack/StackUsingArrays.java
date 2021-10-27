package practice.stack;

public class StackUsingArrays {
    static class Stack {
        int n;
        int[] arr;
        int top;

        Stack(int n) {
            this.n = n;
            arr = new int[n];
            top = -1;
        }

        public void push(int i) {
            if (isFull()) {
                System.out.println("Stack is full.");
                return;
            }
            arr[++top] = i;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return arr[top--];
        }

        public int top() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == n - 1;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.pop();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.top();
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
