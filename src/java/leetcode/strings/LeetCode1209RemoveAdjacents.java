package leetcode.strings;

import java.util.Stack;

public class LeetCode1209RemoveAdjacents {
    public static void main(String[] args) {
        String str = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(str, k));
    }

    private static String removeDuplicates(String str, int k) {

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == str.charAt(i)) {
                count++;
            } else {
                stack.push(str.charAt(i));
            }
            if (count == k) {
                stack.pop();
                count = 0;
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
