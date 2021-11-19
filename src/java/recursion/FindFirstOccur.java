package recursion;

public class FindFirstOccur {
    public static void main(String[] args) {
        int [] arr = {1,2,4,3,2,1,3,5};
        int ans = find(arr,0,3);
        System.out.println("First Occurrence "+ans);
    }

    private static int find(int[] arr, int idx, int key) {
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == key){
            return idx;
        }else{
            int fo =find(arr,idx+1,key);
            return fo;
        }




    }
}
