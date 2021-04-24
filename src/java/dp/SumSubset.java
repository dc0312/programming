package dp;

public class SumSubset {

    private static int sumSubset(int[] arr, int sum, int n) {
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

        // uncomment this code to print table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++)
                System.out.printf("%4d", T[i][j]);
            System.out.printf("\n");
        }
        return T[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("Result : " + (1 == sumSubset(arr, sum, arr.length) ? true : false));
    }
}
