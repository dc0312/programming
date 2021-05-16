package leetcode.dp;

/*
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
* */
public class LeetCode718MaximumLengthRepeatedSubarray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(maxLen(nums1, nums2));
    }

    private static int maxLen(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return maxLen(nums1, nums2, m, n);
    }

    private static int maxLen(int[] nums1, int[] nums2, int m, int n) {
        int T[][] = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                    max = Math.max(max, T[i][j]);
                }
            }
        }
        return max;
    }
}
