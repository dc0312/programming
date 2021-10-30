package binarysearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println("Result : "+logic(arr));
    }

    private static int logic(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int size = arr.length;
        while(low<=high){
            int mid = low + (high - low)/2;

            if(mid > 0 && mid<size-1){
                if(arr[mid-1] < arr[mid] && arr[mid+1]<arr[mid]){
                    return  mid;
                }else if(arr[mid+1]>arr[mid]){
                    low = mid+1;
                }else if(arr[mid-1]>arr[mid]){
                    high = mid-1;
                }
            }else if(mid==0){
                if(arr[0]>arr[1]){
                    return 0;
                }else{
                    return 1;
                }
            }else if(mid == size-1){
                if(arr[size-1]>arr[size-2]){
                    return size-1;
                }else{
                    return size-2;
                }
            }
        }
        return -1;
    }
}
