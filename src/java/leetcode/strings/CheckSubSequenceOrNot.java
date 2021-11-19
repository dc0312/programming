package leetcode.strings;

/**
 * Input: str1 = "AXY", str2 = "ADXCPY"
 * Output: True (str1 is a subsequence of str2)
 *
 * Input: str1 = "AXY", str2 = "YADXCP"
 * Output: False (str1 is not a subsequence of str2)
 *
 * Input: str1 = "gksrek", str2 = "geeksforgeeks"
 * Output: True (str1 is a subsequence of str2)
 */
public class CheckSubSequenceOrNot {
    public static void main(String[] args) {
        String s1 = "axy";
        String s2 = "adxcpy";
        System.out.println("Result : " + check(s1, s2));
        System.out.println("Result : " + check2(s1, s2));
        System.out.println("Result : " + check2(s1, s2));
    }

    private static boolean check2(String s1, String s2) {
        return check(s1, s2, s1.length(), s2.length());
    }

    private static boolean check(String s1, String s2, int m, int n) {
        if (m == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return check(s1, s2, m - 1, n - 1);
        }
        return check(s1, s2, m, n - 1);
    }

    private static boolean check(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int slow = 0;
        int fast = 0;

        while (fast < s2.length()) {
            if (s1.charAt(slow) == s2.charAt(fast)) {
                slow++;
                fast++;
                if (slow == s1.length()) {
                    break;
                }
            } else {
                fast++;
            }
        }
        return slow == s1.length();
    }
}
