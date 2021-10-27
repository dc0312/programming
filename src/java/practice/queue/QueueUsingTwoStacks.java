package practice.queue;

public class QueueUsingTwoStacks {
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

    static class Queue{
        int n;
        Stack s1;
        Stack s2;

        Queue(int n){
            this.n =n;
            s1 = new Stack(n);
            s2 = new Stack(n);
        }

        public void enqueue(int i){
            if(s1.isFull()){
                System.out.println("Queue is full.");
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(i);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public int dequeue(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }
            return s1.pop();
        }

        public int top(){
            return s1.top();
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
