package leetcode.strings;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LeetCode14LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strArr = {"a"};
        System.out.println("Result : " + longestCommonPrefix(strArr));
    }

    private static String longestCommonPrefix(String[] strArr) {
        Arrays.sort(strArr);

        StringBuilder ans = new StringBuilder();

        int i = 0;
        String firstWord = strArr[0];
        String lastWord = strArr[strArr.length - 1];
        while (i < firstWord.length()) {
            while (i < firstWord.length() && firstWord.charAt(i) == lastWord.charAt(i)) {
                ans.append(firstWord.charAt(i));
                i++;
            }
            break;
        }
        return ans.toString();
    }
}
