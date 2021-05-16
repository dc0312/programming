package leetcode.slidingWindow;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
* */
public class LeetCode209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;
        System.out.println(minSubArrayLen(target, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                if (min > j - i + 1) {
                    min = j - i + 1;
                    start = i;
                    end = j + 1;
                }
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        return end - start;
    }
}
