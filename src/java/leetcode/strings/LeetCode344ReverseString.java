package leetcode.strings;

public class LeetCode344ReverseString {
    public static void main(String[] args) {
        String word = "hello";
        reverse(word, "");
    }

    private static void reverse(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = word.charAt(0);
        String ros = word.substring(1);
        reverse(ros, ch + ans);
    }
}
