package practice.stack;

public class StackUsingTwoQueue {
    static class Queue {
        int[] arr;
        int front, rear;
        int n;
        int count;

        Queue(int n) {
            this.n = n;
            front = 0;
            rear = -1;
            arr = new int[n];
            count = 0;
        }

        public void enqueue(int i) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear % n] = i;
            count++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            int temp = arr[front % n];
            front++;
            count--;
            return temp;
        }

        public int top() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[front % n];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == n;
        }
    }

    static class Stack{
        int n;
        Queue q1;
        Queue q2;

        Stack(int n){
            this.n = n;
            q1 = new Queue(n);
            q2 = new Queue(n);
        }

        public void push(int i){
            if(q1.isFull()){
                System.out.println("Stack is full");
                return;
            }
            while(!q1.isEmpty()){
                q2.enqueue(q1.dequeue());
            }
            q1.enqueue(i);
            while(!q2.isEmpty()){
                q1.enqueue(q2.dequeue());
            }
        }

        public int pop(){
            if(q1.isEmpty()){
                System.out.println("Stack is empty.");
                return -1;
            }
            return q1.dequeue();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
