package leetcode.strings;


import java.util.ArrayList;
import java.util.List;

public class LeetCode1002FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        List<String> ans = commonChars(words);
        System.out.println(ans);
    }

    public static List<String> commonChars(String[] words) {
        int[] chars = new int[26];
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars[c - 'a']++;
                if (chars[c - 'a'] % 3 == 0) {
                    ans.add(Character.toString(c));
                }
            }
        }
        return ans;

    }
}
