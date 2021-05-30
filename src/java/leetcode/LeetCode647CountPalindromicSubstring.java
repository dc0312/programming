package leetcode;

public class LeetCode647CountPalindromicSubstring {
    public static void main(String[] args) {
        String input = "abc";
        System.out.println("Result : " + solve(input));
    }

    private static int solve(String input) {
        int begin = 0;
        int end = input.length() - 1;

        int count = 0;

        while (begin < end) {
            if (isPanlindrome(input.substring(begin, end))) {
                count++;
            }

            if (isPanlindrome(input.substring(begin + 1, end))) ;
            {
                count++;
            }
            if (isPanlindrome(input.substring(begin, end - 1))) {
                count++;
            }
            begin++;
            end--;
        }
        return count;
    }

    private static boolean isPanlindrome(String str) {
        int begin = 0;
        int end = str.length() - 1;
        while (begin < end) {
            if (str.charAt(end) != str.charAt(begin)) {
                return false;
            }
            end--;
            begin++;
        }
        return true;
    }


}
