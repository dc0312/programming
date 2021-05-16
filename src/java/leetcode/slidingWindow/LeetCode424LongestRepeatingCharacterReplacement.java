package leetcode.slidingWindow;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LeetCode424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABBABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        int[] freq = new int[26];
        int mostFreqCharacter = 0;
        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            mostFreqCharacter = Math.max(mostFreqCharacter, freq[s.charAt(right) - 'A']);
            int letterToChange = (right - left + 1) - mostFreqCharacter;

            if (letterToChange > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
