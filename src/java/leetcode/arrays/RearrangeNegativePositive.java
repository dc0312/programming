package leetcode.arrays;

import java.util.Arrays;

public class RearrangeNegativePositive {
    public static void main(String[] args) {
        int[] arr = {5, 5, -3, 4, -8, 0, -7, 3, -9, -3, 9, -2, 1};
        rearrange(arr);
        //rearrange2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrange2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            while (left < arr.length && arr[left] < 0) {
                left++;
            }
            while (right > 0 && arr[right] >= 0) {
                right--;
            }

            if (arr[left] >= 0 && arr[right] <= 0) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

    private static void rearrange(int[] arr) {
        int i = 0;
        int pivot = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
