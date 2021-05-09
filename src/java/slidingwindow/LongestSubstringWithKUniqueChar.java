package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string you need to print the size of the longest possible substring that has exactly k unique characters.


Example:
Input:
2
aabacbebebe
3
aaaa
1
Output:
7
4
* */
public class LongestSubstringWithKUniqueChar {
    public static void main(String[] args) {
        String str = "aaaa";
        int k = 1;
        System.out.println("Result : " + longestSubString(str, k));
    }

    private static int longestSubString(String str, int k) {
        int i = 0, j = 0, max = Integer.MIN_VALUE;

        Map<Character, Integer> charMap = new HashMap<>();

        while (j < str.length()) {
            if (charMap.containsKey(str.charAt(j))) {
                charMap.put(str.charAt(j), charMap.get(str.charAt(j)) + 1);
            } else {
                charMap.put(str.charAt(j), 1);
            }

            if (charMap.size() < k) {
                j++;
            } else if (charMap.size() == k) {
                max = Math.max(j - i + 1, max);
                j++;
            } else {
                while (!charMap.isEmpty() && charMap.size() > k) {
                    if (charMap.get(str.charAt(i)) == 1) {
                        charMap.remove(str.charAt(i));
                    } else {
                        charMap.put(str.charAt(i), charMap.get(str.charAt(i)) - 1);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;

    }
}
