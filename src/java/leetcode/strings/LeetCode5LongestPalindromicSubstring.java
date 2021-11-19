package leetcode.strings;

public class LeetCode5LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    private static String longestPalindrome(String s) {
        if(null == s || s.length() <=1){
            return s;
        }
        int start =0; int end=0;
        for(int i =1; i < s.length()-1;i++){
            int len1 = expandAns(s,i,i);
            int len2 = expandAns(s,i,i+1);

            int len = Math.max(len2,len1);

            if(len > end -start){
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start,end+1);

    }

    public static int expandAns(String word, int left, int right){
        while(left >=0 && right < word.length()){
            if(word.charAt(left) != word.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }
}
