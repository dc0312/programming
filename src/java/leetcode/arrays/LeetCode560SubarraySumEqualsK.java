package leetcode.arrays;

/*
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
* */
public class LeetCode560SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int begin = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while (end < nums.length) {
            if (sum < k) {
                sum += nums[end];
            } else if (sum >= k) {
                while (sum >= k) {
                    if (sum == k) {
                        count++;
                    }
                    sum -= nums[begin];
                    begin++;
                }
            }
            end++;
        }
        return count;
    }
}
