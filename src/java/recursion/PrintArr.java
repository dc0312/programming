package recursion;

public class PrintArr {
    public static void main(String[] args) {
        int [] arr ={2,5,3,1,4};
        print(arr,0);
    }

    private static void print(int[] arr, int idx) {
        if(idx==arr.length){
            return;
        }
        print(arr,idx+1);
        System.out.println(arr[idx]);
    }
}
