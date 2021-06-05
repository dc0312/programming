package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
* */
public class LeetCode350IntersectionofTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] ans = intersect(nums1, nums2);
        Arrays.stream(ans).forEach(System.out::println);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i : nums1) {
            numMap.put(i, numMap.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i : nums2) {
            if (numMap.containsKey(i)) {
                if (numMap.get(i) > 0) {
                    ansList.add(i);
                    numMap.put(i, numMap.get(i) - 1);
                }
            }
        }

        int[] ans = new int[ansList.size()];
        int k = 0;
        for (int i : ansList) {
            ans[k++] = i;
        }
        return ans;
    }
}
