package dp;

public class KnapsackTopDown {

    private static void knapsack(int[] wt, int[] val, int w, int n) {
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

        // uncomment this code to print table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++)
                System.out.printf("%4d", T[i][j]);
            System.out.printf("\n");
        }
        System.out.println(T[n][w]);
        int res = T[n][w];

        while (res > 0 && n > 0) {
            if (res == T[n - 1][w]) {
                n--;
                continue;
            } else {
                System.out.print(wt[n - 1] + " ");
                res = res - val[n - 1];
                w = w - wt[n - 1];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] wt = {2, 1, 3, 4, 5};
        int[] val = {7, 2, 3, 1, 4};
        int w = 7;
        //System.out.println("Max Val : " + knapsack(wt, val, w, wt.length));
        knapsack(wt, val, w, wt.length);
    }
}
