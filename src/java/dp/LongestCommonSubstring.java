package dp;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "12321";
        String s2 = "32147";
        System.out.println("Result : " + lcs(s1, s2));
    }

    private static int lcs(String s1, String s2) {

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        int[][] T = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                } else {
                    T[i][j] = 0;
                }
                max = Math.max(max, T[i][j]);
            }
        }

        return max;

    }
}
