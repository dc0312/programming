package practice.stack;

import java.util.Arrays;

public class    NextGreaterElement {
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
        //int[] input = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        int[] input = {2,10,4,2,1,2,6,1,7,2,9};
        logic(input);
    }

    private static void logic(int[] input) {
        int[] output = new int[input.length];
        Stack stack = new Stack(input.length);

        for (int i = input.length-1; i >= 0; i--) {

            if(!stack.isEmpty() && stack.top() < input[i]){
                while(!stack.isEmpty() && stack.top() < input[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                output[i]=-1;
            }else{
                output[i] =  stack.top();
            }

            stack.push(input[i]);

        }

        System.out.println(Arrays.toString(output));
    }
}
