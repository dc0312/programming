package dp;

/*
Coin Change Problem Minimum Numbers of coins
Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
Example:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents */
public class CoinChangeProblem2 {

    public static int minimumCoin(int[] coin, int sum) {
        int n = coin.length;
        int[][] T = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) {
                    T[i][j] = 0;
                }
                if (i == 0) {
                    T[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] <= j) {
                    T[i][j] = Math.min(1 + T[i][j - coin[i - 1]], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        return T[n][sum] != Integer.MAX_VALUE - 1 ? T[n][sum] : -1;
    }

    public static void main(String[] args) {
        int coins[] = {25, 10, 5};
        int V = 30;
        System.out.println("Result : " + minimumCoin(coins, V));
    }
}
