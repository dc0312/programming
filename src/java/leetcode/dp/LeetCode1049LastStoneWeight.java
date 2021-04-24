package leetcode.dp;

public class LeetCode1049LastStoneWeight {

    public static int lastStoneWeightII(int[] arr) {
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
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Result : " + lastStoneWeightII(stones));
        int[] stones1 = {31, 26, 33, 21, 40};
        System.out.println("Result : " + lastStoneWeightII(stones1));
    }
}
