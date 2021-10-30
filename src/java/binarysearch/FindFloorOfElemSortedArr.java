package binarysearch;

public class FindFloorOfElemSortedArr {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 8, 10, 10, 12, 19};
        System.out.println("Result : " + logic(arr, 5));
    }

    private static int logic(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return arr[mid];
            } else if (arr[mid] < key) {
                res = arr[mid];
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            }
        }
        return res;
    }
}
