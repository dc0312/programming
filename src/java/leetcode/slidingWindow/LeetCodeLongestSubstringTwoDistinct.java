package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
For example, Given s = “eceba”,
T is "ece" which its length is 3.
 */
public class LeetCodeLongestSubstringTwoDistinct {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int counter = 0;
        while (j < s.length()) {
            if (countMap.containsKey(s.charAt(j))) {
                countMap.put(s.charAt(j), countMap.get(s.charAt(j)) + 1);
            } else {
                countMap.put(s.charAt(j), 1);
                counter++;
            }

            while (counter > 2) {
                countMap.put(s.charAt(i), countMap.get(s.charAt(i)) - 1);
                if (countMap.get(s.charAt(i)) == 0) {
                    counter--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
