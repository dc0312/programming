package dp;

/*
* Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
Examples :

Input : aebcbda
Output : 2
* */
public class MinDelToMakePalindrome {
    public static void main(String[] args) {
        String s1 = "aebcbda";
        System.out.println("Result : " + minDel(s1));
    }

    private static int minDel(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();

        int m = s1.length();
        int n = s1.length();

        int T[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (m == 0 || n == 0) {
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
        return s1.length() - T[m][n];
    }
}
