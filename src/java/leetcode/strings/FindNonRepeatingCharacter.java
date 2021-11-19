package leetcode.strings;

/**
 * Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”,
 * then the output should be ‘f’ and if the input string is “GeeksQuiz”, then the output should be ‘G’.
 */
public class FindNonRepeatingCharacter {
    public static void main(String[] args) {
        String word = "GeeksQuiz";
        System.out.println("Result : " + check(word));
    }

    private static char check(String word) {
        int[] charArr = new int[256];

        for (char ch : word.toCharArray()) {
            charArr[ch]++;
        }
        for (char ch : word.toCharArray()) {
            if (charArr[ch] == 1) {
                return ch;
            }
        }
        return '1';
    }
}
