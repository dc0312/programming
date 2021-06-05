package leetcode.arrays;

import java.util.*;

/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.



Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
* */
public class LeetCode532KdiffPairsinanArray {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs2(nums, k));
    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int pairs = 0;
        for (int val : nums) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }

        for (int key : mp.keySet()) {
            int val = mp.get(key);

            if (k > 0 && mp.containsKey(key + k)) pairs++;
            else if (k == 0 && val > 1) pairs++; //if arr=[1,1] & k=0  than pair will be {1,1}
        }

        return pairs;
    }

    public static int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int n = nums.length;
        Set<String> pairs = new HashSet<>();
        while (i < n && j < n) {
            if (nums[j] - nums[i] == k && i != j) {
                pairs.add(nums[j] + "-" + nums[i]);
                i++;
                j++;
            } else if (nums[j] - nums[i] < k) {
                j++;
            } else {
                i++;
            }
        }
        return pairs.size();
    }
}
