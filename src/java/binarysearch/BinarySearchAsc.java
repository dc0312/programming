package binarysearch;

public class BinarySearchAsc {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Result : " + logic(arr, 3));
        System.out.println("Result : " + logic(arr, 10));
    }

    private static int logic(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            //int mid = (low+high)/2; This will result into int overflow.
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
