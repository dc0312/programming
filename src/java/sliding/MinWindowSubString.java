package sliding;

import java.util.HashMap;

public class MinWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int counter = countMap.size();
        int begin = 0, end = 0, start = 0, finish = Integer.MAX_VALUE-1;

        while (end < s.length()) {
            char cEnd = s.charAt(end);

            if (!countMap.isEmpty()) {
                if (countMap.containsKey(cEnd)) {
                    countMap.put(cEnd, countMap.get(cEnd) - 1);
                    if (countMap.get(cEnd) == 0) {
                        counter--;
                    }
                }

            }

            while (counter == 0) {
                char cBegin = s.charAt(begin);

                if (!countMap.isEmpty()) {
                    if (countMap.containsKey(cBegin)) {
                        countMap.put(cBegin, countMap.get(cBegin) + 1);
                        if (countMap.get(cBegin) > 0) {
                            counter++;
                        }
                    }

                }
                if (end - begin + 1 < finish - start + 1) {
                    finish = end;
                    start = begin;
                }
                begin++;
            }
            end++;
        }
        return s.substring(start, finish + 1);
    }
}
