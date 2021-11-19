package leetcode.strings;

/**
 * Input:
 * string a = "GeeksforGeeks"
 * string b = "Gks"
 * <p>
 * Output: 4
 * <p>
 * Explanation:
 * The four strings are - (Check characters marked in bold)
 * GeeksforGeeks
 * GeeksforGeeks
 * GeeksforGeeks
 * GeeksforGeeks
 */
public class NumberOfTimesSubSequenceInAString {
    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        String s2 = "Gks";
        System.out.println("Result : " + check(s1, s2));
        System.out.println("Result : " + checkDP(s1, s2));
    }

    private static int checkDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int T[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    T[i][j] = 0;
                }
                if (j == 0) {
                    T[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }

        return T[m][n];

    }

    private static int check(String s1, String s2) {
        return check(s1, s2, s1.length(), s2.length());
    }

    private static int check(String s1, String s2, int m, int n) {
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return check(s1, s2, m - 1, n - 1) + check(s1, s2, m - 1, n);
        }
        return check(s1, s2, m - 1, n);
    }
}
