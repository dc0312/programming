package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode349IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int ans[] = intersection(nums1, nums2);
        Arrays.stream(ans).forEach(System.out::println);
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        Set<Integer> intersectSet = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                intersectSet.add(i);
            }
        }

        int ans[] = new int[intersectSet.size()];
        int k = 0;
        for (int i : intersectSet) {
            ans[k++] = i;
        }
        return ans;
    }

/**Complexity is O(nlog(n))*/
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        int m = nums1.length - 1;
//        int n = nums2.length - 1;
//        Set<Integer> integers = new HashSet<>();
//        while (m >= 0 && n >= 0) {
//            if (nums1[m] == nums2[n]) {
//                integers.add(nums1[m]);
//                m--;
//                n--;
//            } else if (nums1[m] > nums2[n]) {
//                m--;
//            } else {
//                n--;
//            }
//        }
//        int[] ans = new int[integers.size()];
//        int k = 0;
//        for (Integer i : integers) {
//            ans[k++] = i;
//        }
//        return ans;
//    }
}
