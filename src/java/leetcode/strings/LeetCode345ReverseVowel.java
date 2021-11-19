package leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode345ReverseVowel {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        char [] wordArr = s.toCharArray();
        Set<Character> charList = new HashSet<>();
        charList.add('a');
        charList.add('e');
        charList.add('i');
        charList.add('o');
        charList.add('u');
        charList.add('A');
        charList.add('E');
        charList.add('I');
        charList.add('O');
        charList.add('U');

        int left =0;
        int right = s.length()-1;
        while(left<=right){
            while(left<=right && !charList.contains(wordArr[left])){
                left++;
            }
            while(left<=right && !charList.contains(wordArr[right])){
                right--;
            }
            if(charList.contains(wordArr[right]) && charList.contains(wordArr[left])){
                char temp = wordArr[left];
                wordArr[left] = wordArr[right];
                wordArr[right] = temp;
                left++;
                right--;
            }

        }

        return new String(wordArr);
    }
}
