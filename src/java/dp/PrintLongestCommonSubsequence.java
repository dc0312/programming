package dp;

import java.util.Stack;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "acbcf";
        String s2 = "abcdaf";
//        String s1 = "12341";
//        String s2 = "341213";
        System.out.println("Result : " + lcs(s1, s2));
    }

    private static String lcs(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

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
                if (arr1[i - 1] == arr2[j - 1]) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                } else {
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        Stack s = new Stack();
        while (m > 0 && n > 0) {
            if (arr1[m - 1] == arr2[n - 1]) {
                s.push(arr1[m - 1]);
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

        StringBuilder stringBuilder = new StringBuilder();

        while (!s.isEmpty()) {
            stringBuilder.append(s.pop());
        }
        return stringBuilder.toString();
    }
}
