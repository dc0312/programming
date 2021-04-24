package dp;

public class KnapsackTopDown {

    private static int knapsack(int[] wt, int[] val, int w, int n) {
        int[][] T = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    T[i][j] = Math.max(val[i - 1] + T[i - 1][j - wt[i - 1]], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        return T[n][w];
    }

    public static void main(String[] args) {
        int[] wt = {2, 3, 5, 4, 7, 9};
        int[] val = {3, 5, 7, 2, 4, 6};
        int w = 15;
        System.out.println("Max Val : " + knapsack(wt, val, w, wt.length));
    }
}
