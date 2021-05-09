package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.
* */
public class CountAnagrams {
    public static void main(String[] args) {
        String s = "aabaabaa";
        String ana = "aaba";
        System.out.println("Result : " + countAnagram(s, ana));
    }

    private static int countAnagram(String s, String ana) {
        Map<Character, Integer> origMap = new HashMap<>();
        for (char c : ana.toCharArray()) {
            if (origMap.containsKey(c)) {
                origMap.put(c, origMap.get(c) + 1);
            } else {
                origMap.put(c, 1);
            }
        }

        Map<Character, Integer> modMap = new HashMap<>();


        int i = 0, j = 0, anaLen = ana.length();
        int count = 0;

        while (j < s.length()) {
            if (origMap.containsKey(s.charAt(j))) {
                if (modMap.containsKey(s.charAt(j))) {
                    modMap.put(s.charAt(j), modMap.get(s.charAt(j)) + 1);
                } else {
                    modMap.put(s.charAt(j), 1);
                }
            }

            if (j - i + 1 < anaLen) {
                j++;
            } else if (j - i + 1 == anaLen) {
                if (origMap.equals(modMap)) {
                    count++;
                }
                if (modMap.containsKey(s.charAt(i))) {
                    if (modMap.get(s.charAt(i)) == 1) {
                        modMap.remove(s.charAt(i));
                    } else {
                        modMap.put(s.charAt(i), modMap.get(s.charAt(i)) - 1);
                    }
                }
                i++;
                j++;
            }
        }
        return count;
    }
}
