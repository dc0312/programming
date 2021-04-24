package dp;

public class KnapSackRecursive {

    private static int knapsack(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
        } else {
            return knapsack(wt, val, w, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] wt = {2, 3, 5, 4, 7, 9};
        int[] val = {3, 5, 7, 2, 4, 6};
        int w = 15;
        System.out.println("Max Val : " + knapsack(wt, val, w, wt.length));
    }

}
