package practice.queue;

public class QueueUsingArrays {
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
            count=0;
        }

        public void enqueue(int i) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear % n] = i;
            count++;
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }
             int temp = arr[front%n];
            front ++;
            count--;
            return temp;
        }

        public int top(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[front%n];
        }

        public boolean isEmpty(){
            return count==0;
        }

        public boolean isFull() {
            return count == n;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.top());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
