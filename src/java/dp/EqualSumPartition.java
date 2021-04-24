package dp;

public class EqualSumPartition {

    private static boolean equalSumPartition(int arr[]) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int n = arr.length;
        if (sum % 2 != 0) {
            return false;
        } else {
            return sumSubset(arr, sum / 2, n);
        }
    }

    private static boolean sumSubset(int[] arr, int sum, int n) {
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
        return 0 == T[n][sum] ? false : true;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 7};
        System.out.println("Result : " + equalSumPartition(arr));
    }
}
