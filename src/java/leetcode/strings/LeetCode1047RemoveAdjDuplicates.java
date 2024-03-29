package leetcode.strings;

import java.util.Stack;

/*
You are given a string s. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
*/
public class LeetCode1047RemoveAdjDuplicates {
    public static void main(String[] args) {
        String str = "azxxxzy";
        System.out.println(removeAdjacents(str));
        System.out.println(removeAdjacents2(str));
    }

    private static String removeAdjacents2(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                if(stack.peek()== ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }

        String ans ="";
        while(!stack.isEmpty()){
            ans = stack.pop() +ans;
        }
        return ans;
    }

    private static String removeAdjacents(String S) {
        char[] ch = new char[S.length()];
        int i = 0;

        for (int j = 0; j < S.length(); j++) {
            if (i > 0 && ch[i - 1] == S.charAt(j)) {
                i--;
            } else {
                ch[i] = S.charAt(j);
                i++;
            }
        }
        return new String(ch, 0, i);
    }
}
