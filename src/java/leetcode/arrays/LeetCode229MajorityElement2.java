package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeetCode229MajorityElement2 {
    public static void main(String[] args) {
        //int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {3, 3};
        System.out.println("Result : " + majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int maj1 = -1;
        int maj2 = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == maj1) {
                count1++;
            } else if (nums[i] == maj2) {
                count2++;
            } else if (count1 == 0) {
                maj1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                maj2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == maj1) {
                count1++;
            } else if (num == maj2) {
                count2++;
            }
        }

        ArrayList ans = new ArrayList();
        int limit = nums.length / 3;
        if (count1 > limit) {
            ans.add(maj1);
        }
        if (count2 > limit) {
            ans.add(maj2);
        }
        return ans;
    }
}
