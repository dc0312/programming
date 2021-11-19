package leetcode.arrays;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
 * same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 * */
public class LeetCode75Sort0s1s2s {
    public static void main(String[] args) {
        int [] arr = {2,0,2,1,1,0};
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArr(int[] arr) {
        int left =0;
        int mid =0;
        int right=arr.length-1;

        while(mid<=right){
            if(arr[mid]==0){
                swap(arr,left,mid);
                left++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else if(arr[mid]==2){
                swap(arr,right,mid);
                right--;
            }
        }
    }

    private static void swap(int[] arr, int left, int mid) {
        int temp = arr[left];
        arr[left] = arr[mid];
        arr[mid] = temp;
    }
}
