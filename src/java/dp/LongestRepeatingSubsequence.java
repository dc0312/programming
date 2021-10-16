package dp;

/*
Input: str = "aabb"
Output: "ab"

Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a'
(second). Note that 'b' cannot be considered
as part of subsequence as it would be at same
index in both.
* */
public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        //String str = "AABEBCDD";
        String str = "aab";
        lrs(str);
    }

    private static void lrs(String str) {
        int m = str.length(), n = str.length();
        int T[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                } else {
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.printf("%4d", T[i][j]);
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (T[i][j] == T[i - 1][j - 1] + 1) {
                sb.append(str.charAt(i - 1));
                i--;
                j--;
            } else {
                if (T[i][j] == T[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println("Result : " + sb.reverse());
    }
}
