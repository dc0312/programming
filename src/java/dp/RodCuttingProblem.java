package dp;

public class RodCuttingProblem {

    public static int rodCuttingProblem(int[] len, int[] price, int N) {
        int n = len.length;

        int[][] T = new int[n + 1][N + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (len[i - 1] <= j) {
                    T[i][j] = Math.max(price[i - 1] + T[i][j - len[i - 1]], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }

        return T[n][N];
    }

    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int N = 8;
        System.out.println("Result : " + rodCuttingProblem(length, price, N));
    }
}
