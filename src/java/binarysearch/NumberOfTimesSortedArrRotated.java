package binarysearch;

public class NumberOfTimesSortedArrRotated {
    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12};
//        int arr[] = {2,1};
//        int arr[] = {2,2,2,1};

        System.out.println("Result : " + alterNativeLogic(arr));
    }

    private static int alterNativeLogic(int [] nums){
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
