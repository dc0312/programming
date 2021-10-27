package practice.queue;

public class QueueUsingTwoStacksO1 {
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

    static class Queue {
        int n;
        Stack input;
        Stack output;
        int nElems;

        Queue(int n) {
            this.n = n;
            input = new Stack(n);
            output = new Stack(n);
            nElems = 0;
        }

        public void enqueue(int i) {
            if (nElems == n) {
                System.out.println("Queue is full.");
                return;
            }
            input.push(i);
            nElems++;
        }

        public int dequeue() {
            if (nElems == 0) {
                System.out.println("Queue is empty ");
                return -1;
            }
            if (!output.isEmpty()) {
                nElems--;
                return output.pop();
            } else {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
                nElems--;
                return output.pop();
            }
        }

        public int top() {
            if (nElems == 0) {
                System.out.println("Queue is empty ");
                return -1;
            }
            if (!output.isEmpty()) {
                return output.top();
            } else {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
                return output.top();
            }
        }

    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.top());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
