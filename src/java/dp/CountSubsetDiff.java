package dp;

public class CountSubsetDiff {

    private static int countSubsetDiff(int[] arr, int diff, int n) {
        int sum = 0;
        int cnt = 0;
        for (int i : arr) {
            sum += i;
            if (i == 0)
                cnt = cnt + 1;
        }
        if ((diff + sum) % 2 != 0) {
            return 0;
        }
        int s1 = (diff + sum) / 2;

        return (int) (Math.pow(2, cnt) * countSubsetSum(arr, s1, n));

    }

    private static int countSubsetSum(int[] arr, int s1, int n) {
        int[][] T = new int[n + 1][s1 + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s1 + 1; j++) {
                if (i == 0) {
                    T[i][j] = 0;
                }
                if (j == 0) {
                    T[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s1 + 1; j++) {
                if (arr[i - 1] == 0) {
                    T[i][j] = T[i - 1][j];
                } else if (arr[i - 1] <= j) {
                    T[i][j] = T[i - 1][j] + T[i - 1][j - arr[i - 1]];
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        return T[n][s1];
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int diff = 1;
        System.out.println("Result : " + countSubsetDiff(arr, diff, arr.length));
    }
}
