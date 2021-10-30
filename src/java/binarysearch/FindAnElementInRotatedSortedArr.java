package binarysearch;

public class FindAnElementInRotatedSortedArr {
    public static void main(String[] args) {
        //int arr[] = {15, 18, 2, 3, 6, 12};
        int arr[] = {1, 2, 6, 12,18};
//        int arr[] = {2,1};
//        int arr[] = {2,2,2,1};

        System.out.println("Result : " + findElementInRotatedArr(arr, 6));
        System.out.println("Result : " + findElementInRotatedArr(arr, 18));
    }

    private static int findElementInRotatedArr(int[] arr, int key) {

        if (arr[0] < arr[arr.length - 1]) {
            return findElement(arr, 0, arr.length - 1, key);
        }

        int rotatedArr = alterNativeLogic(arr);

        int retValFirstHalf = findElement(arr, 0, rotatedArr - 1, key);
        int retValSecondHalf = findElement(arr, rotatedArr, arr.length - 1, key);

        return retValFirstHalf != -1 ? retValFirstHalf : retValSecondHalf;
    }

    private static int findElement(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int alterNativeLogic(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        if (nums[lo] < nums[hi]) return nums[lo];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }

        return hi;
    }
}
