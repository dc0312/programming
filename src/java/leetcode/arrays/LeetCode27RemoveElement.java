package leetcode.arrays;

public class LeetCode27RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println("Result : " + removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int begin = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] == val) {
                end++;
                continue;
            }
            nums[begin] = nums[end];
            begin++;
            end++;

        }
        return begin;
    }
}
