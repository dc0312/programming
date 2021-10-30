package binarysearch;

public class BinarySearchOrderNotKnown {
    public static void main(String[] args) {
        //int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr[] = {10,9,8,7,6,5,4,3,2,1};
        System.out.println("Result : " + logic(arr, 3));
    }

    private static int logic(int[] arr, int key) {
        if(arr.length == 1){
            if(arr[0]==key){
                return 0;
            }else{
                return -1;
            }
        }

        boolean isAsc = arr[0]<arr[1] ? true : false;

        if(isAsc){
            return binarySearchAsc(arr,key);
        }else{
            return binarySearchDsc(arr,key);
        }
    }

    private static int binarySearchAsc(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] > key){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    private static int binarySearchDsc(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] > key){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
