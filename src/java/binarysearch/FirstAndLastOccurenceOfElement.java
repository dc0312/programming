package binarysearch;

public class FirstAndLastOccurenceOfElement {
    public static void main(String[] args) {
        int [] arr = {1,2,3,3,3,4,5,5,5,5,6,7};
        System.out.println("First Occurrence "+firstOccur(arr,3));
        System.out.println("Last Occurrence "+lastOccur(arr,5));
    }

    private static int lastOccur(int[] arr, int key) {
        int low =0;
        int high = arr.length-1;
        int res = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==key){
                res = mid;
                low = mid +1;
            }else if(arr[mid] > key){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    private static int firstOccur(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==key){
                res = mid;
                high = mid-1;
            }else if(arr[mid]>key){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return res;
        
    }
}
