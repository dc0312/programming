package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1160GoodStrings {
    public static void main(String[] args) {
        String[] words = {"boygirdlggnh"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println("Result : " + countCharacters(words, chars));
    }

    private static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println(countMap);
        ArrayList<String> ans = new ArrayList<>();

        for (String word : words) {
            int[] charTemp = new int[26];
            for (char ch : word.toCharArray()) {
                charTemp[ch - 'a']++;
            }
            boolean isGoodString = true;
            for (char ch : word.toCharArray()) {
                System.out.println("charTemp[ch - 'a']" + charTemp[ch - 'a']);
                System.out.println("countMap.get(ch) " + countMap.get(ch));
                System.out.println("Char " + ch);
                if (!countMap.containsKey(ch) || charTemp[ch - 'a'] > countMap.get(ch)) {
                    System.out.println(word);
                    isGoodString = false;
                    break;
                }
            }
            if (isGoodString) {
                ans.add(word);
            }
        }
        int len = 0;
        for (String w : ans) {
            System.out.println("==> w " + w);
            len += w.length();
        }
        return len;
    }
}
