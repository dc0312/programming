package slidingwindow;

/*
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

Example:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.
*/
public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int sum = 0;
        int i = 0, j = 0;
        int maxSum = Integer.MIN_VALUE;
        while (j < arr.length) {
            sum = sum + arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println("Result : " + findMaxSumSubArray(k, arr));
    }
}
