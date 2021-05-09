package slidingwindow;

/*
Given an array containing N positive integers and an integer K. Your task is to find the length of the
longest Sub-Array with sum of the elements equal to the given value K.

For Input:
1
7 5
4 1 1 1 2 3 5
your output is:
4
* */
public class LargestSubarrayofSumK {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5, 1, 1, 1, 1, 1, 1};
        int sum = 5;
        System.out.println("Result : " + largestSubarray(arr, sum));
    }

    private static int largestSubarray(int[] arr, int sum) {
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        int tempSum = 0;
        while (j < arr.length) {
            tempSum += arr[j];
            if (tempSum < sum) {
                j++;
            } else if (tempSum == sum) {
                max = Math.max(j - i + 1, max);
                j++;
            } else {
                tempSum -= arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
