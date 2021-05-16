package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
* */
public class LeetCode438FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> ans = findAnagrams(s, p);
        ans.stream().forEach(System.out::println);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int counter = countMap.size();
        int begin = 0, end = 0;
        while (end < s.length()) {
            char cEnd = s.charAt(end);
            if (countMap.containsKey(cEnd)) {
                countMap.put(cEnd, countMap.get(cEnd) - 1);
                if (countMap.get(cEnd) == 0) {
                    counter--;
                }
            }

            while (counter == 0) {
                char cBegin = s.charAt(begin);
                if (countMap.containsKey(cBegin)) {
                    countMap.put(cBegin, countMap.get(cBegin) + 1);
                    if (countMap.get(cBegin) > 0) {
                        counter++;
                    }
                }
                if (end - begin + 1 == p.length()) {
                    result.add(begin);
                }

                begin++;
            }
            end++;
        }

        return result;
    }
}
