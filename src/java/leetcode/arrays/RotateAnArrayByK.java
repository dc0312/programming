package leetcode.arrays;

import java.util.Arrays;

public class RotateAnArrayByK {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int k =3;
        rotate(nums,k-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        reverse(nums,0,k);
        reverse(nums,k+1,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    private static void reverse(int[] nums, int i, int k) {
        while(i<=k){
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            i++;
            k--;
        }
    }
}
