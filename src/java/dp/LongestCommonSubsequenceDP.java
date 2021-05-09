package dp;

public class LongestCommonSubsequenceDP {

    public static void main(String[] args) {
        String s1 = "acbcf";
        String s2 = "abcdaf";
        System.out.println("Result : " + lcs(s1, s2));
    }

    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] T = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                } else {
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
        // uncomment this code to print table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++)
                System.out.printf("%4d", T[i][j]);
            System.out.printf("\n");
        }

        return T[m][n];
    }
}
