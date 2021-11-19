package leetcode.arrays;

import java.util.Arrays;

public class LeetCode31NextPermutation {
    public static void main(String[] args) {
        int[] nums = {5,1,4,3,2};
        findNextPermutaion(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void findNextPermutaion(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }
        System.out.println(idx1);
        if(idx1==-1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[idx1]) {
                idx2 = i;
                break;
            }
        }
        System.out.println(idx2);

        swap(nums, idx1, idx2);
        System.out.println(Arrays.toString(nums));
        reverse(nums, idx1 + 1, nums.length - 1);

    }

    private static void reverse(int[] nums, int l, int length) {

        int left = l;
        int right = length;

        while (left <= right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
