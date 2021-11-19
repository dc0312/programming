package leetcode.arrays;

import java.util.Arrays;

public class RearrangeNegativePositive2 {
    public static void main(String[] args) {
        int[] arr = {5, 5, -3, 4, -8, 0, -7, 3, -9, -3, 9, -2, 1};
        //int[] arr = {3,-2,4,-5,1,6};
        System.out.println(Arrays.toString(arr));
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrange(int[] arr) {
        int i = 0;
        int pivot = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < pivot) {
                int k =j;
                while(k>i){
                    swap(arr, k, k-1);
                    k--;
                }
                i++;
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
