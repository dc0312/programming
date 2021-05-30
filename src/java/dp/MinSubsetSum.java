package dp;

/*
Sum of subset differences
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:
Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
* */
public class MinSubsetSum {

    private static int minSubsetSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int n = arr.length;
        int[][] T = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    T[i][j] = 0;
                }
                if (j == 0) {
                    T[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    T[i][j] = Math.max(T[i - 1][j - arr[i - 1]], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }

//        // uncomment this code to print table
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= sum; j++)
//                System.out.printf("%4d", T[i][j]);
//            System.out.printf("\n");
//        }

        int[] val = new int[sum / 2 + 1];
        for (int i = 0; i <= sum / 2; i++) {
            if (T[n][i] != 0) {
                val[i] = i;
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i : val) {
            min = Math.min(min, sum - 2 * i);
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 4, 1, 8, 1};
        System.out.println("Min Val : " + minSubsetSum(arr));
    }
}
