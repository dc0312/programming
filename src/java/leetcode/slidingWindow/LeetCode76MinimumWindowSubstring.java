package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
* */
public class LeetCode76MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (null != countMap.get(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        int i = 0, j = 0, start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int count = countMap.size();

        while (j < s.length()) {
            if (null != countMap.get(s.charAt(j))) {
                countMap.put(s.charAt(j), countMap.get(s.charAt(j)) - 1);
                if (countMap.get(s.charAt(j)) == 0) {
                    count--;
                }
            }

            while (count <= 0) {
                if (min > j - i + 1) {
                    start = i;
                    end = j + 1;
                    min = j - i + 1;
                }
                if (countMap.containsKey(s.charAt(i))) {
                    countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
                    if (countMap.get(s.charAt(i)) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;

        }

        return s.substring(start, end);
    }
}
