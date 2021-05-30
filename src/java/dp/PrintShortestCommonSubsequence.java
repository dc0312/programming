package dp;

import java.util.Stack;

/*
Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
Examples:

Input:   str1 = "geek",  str2 = "eke"
Output: "geeke" ==> 5
 */
public class PrintShortestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Result : " + scs(s1, s2));
    }

    private static String scs(String s1, String s2) {
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

        int longSubLen = T[m][n];

        Stack s = new Stack();
        while (m > 0 && n > 0) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                s.push(s1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (T[m - 1][n] > T[m][n - 1]) {
                    s.push(s1.charAt(m - 1));
                    m--;
                } else {
                    s.push(s1.charAt(n - 1));
                    n--;
                }
            }
        }

        while (m > 0) {
            s.push(s1.charAt(m - 1));
            m--;
        }
        while (n > 0) {
            s.push(s1.charAt(n - 1));
            n--;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!s.isEmpty()) {
            stringBuilder.append(s.pop());
        }

        System.out.println("==>" + stringBuilder.toString());


        return stringBuilder.toString();
    }
}
