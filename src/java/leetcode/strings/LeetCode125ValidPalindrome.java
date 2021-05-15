package leetcode.strings;

/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 */
public class LeetCode125ValidPalindrome {

    public static void main(String[] args) {
        String str = "race  car";
        System.out.println("Result : " + logic(str));
    }

    private static boolean logic(String str) {
        str = str.toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (!isAlphaNumeric(str.charAt(i))) {
                i++;
            } else if (i < j && !isAlphaNumeric(str.charAt(j))) {
                j--;
            } else {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

        }
        return true;
    }

    private static boolean isAlphaNumeric(char charAt) {
        return ('a' <= charAt && 'z' >= charAt) || ('0' <= charAt && charAt <= '9');
    }

    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
