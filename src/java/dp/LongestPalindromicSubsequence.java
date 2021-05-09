package dp;

/*
Given a sequence, find the length of the longest palindromic subsequence in it.
Example :
Input:"bbbab"
Output:4
*/
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "agbcba";
        System.out.println("Result : " + longestPalindrome(s1));
    }

    private static int longestPalindrome(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();

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

        return T[m][n];
    }
}
