package practice.stack;

public class MinStack {
    static class StackData{
        int data;
        int min;

        StackData(int data, int min){
            this.data =data;
            this.min = min;
        }
    }

    StackData [] st;
    int capacity;
    int size;

    MinStack(int capacity){
        this.capacity = capacity;
        st = new StackData[capacity];
    }

    public void push(int data){
        if(size-1 == capacity){
            System.out.println("Stack is full.");
        }
        if(size==0){
            st[++size] = new StackData(data,data);
        }else{
            int min = Math.min(data,min());
            st[++size] = new StackData(data,min);
        }

    }

    public int pop(){
        if(size ==0){
            return -1;
        }
        return st[size--].data;
    }

    public int top(){
        if(size ==0){
            return -1;
        }
        return st[size].data;
    }

    public int min(){
        if(size ==0){
            return -1;
        }
        return st[size].min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack(5);
        minStack.push(2);
        minStack.push(4);
        System.out.println("Min : "+minStack.min());
        minStack.push(1);
        System.out.println("Min : "+minStack.min());
        minStack.push(5);
        System.out.println("Min : "+minStack.min());
        System.out.println("Top : "+minStack.top());
        minStack.pop();
        minStack.pop();
        System.out.println("Min : "+minStack.min());
    }
}
