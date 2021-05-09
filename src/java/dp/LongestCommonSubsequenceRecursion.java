package dp;

/*
* Longest Common Subsequence Problem solution using recursion
Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.

For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.*/
public class LongestCommonSubsequenceRecursion {

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return lcs(s1.toCharArray(), s2.toCharArray(), m, n);
    }

    private static int lcs(char[] arr1, char[] arr2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (arr1[m - 1] == arr2[n - 1]) {
            return 1 + lcs(arr1, arr2, m - 1, n - 1);
        } else {
            return Math.max(lcs(arr1, arr2, m - 1, n), lcs(arr1, arr2, m, n - 1));
        }
    }


    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Result : " + lcs(s1, s2));
    }
}
