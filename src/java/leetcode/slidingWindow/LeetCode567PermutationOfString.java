package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 * Input: s1 = "trinitrophenylmethylnitramine", s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
 *  * Output: false
 * "trinitrophenylmethylnitramine"
 * "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
 */
public class LeetCode567PermutationOfString {
    public static void main(String[] args) {
        String s1 = "trinitrophenylmethylnitramine";
        String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
        System.out.println("Result : " + checkInclusion(s1, s2));
    }

    private static boolean checkInclusion(String p, String s) {
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

        return result.size()>0;
    }
}
