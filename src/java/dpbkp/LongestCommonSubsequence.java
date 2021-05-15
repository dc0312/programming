package dpbkp;

import java.util.Stack;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Result : " + lcs(s1, s2));
        System.out.println("Result : " + lcsTopDown(s1, s2));
    }

    private static int lcs(String s1, String s2) {
        return lcs(s1, s2, s1.length(), s2.length());
    }

    private static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
    }

    private static int lcsTopDown(String s1, String s2) {
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


        Stack s = new Stack();
        while (m > 0 && n > 0) {
            if (T[m][n] != T[m - 1][n]) {
                s.push(s1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (T[m - 1][n] > T[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();

        return T[m][n];
    }
}
