package leetcode.slidingWindow;

/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
* */
public class LeetCode3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (j < s.length()) {
            freq[s.charAt(j)]++;
            if (freq[s.charAt(j)] > 1) {
                while (freq[s.charAt(j)] > 1) {
                    freq[s.charAt(i)]--;
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
