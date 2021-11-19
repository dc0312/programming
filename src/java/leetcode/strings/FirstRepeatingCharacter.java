package leetcode.strings;

/**
 * nput: ch = “geeksforgeeks”
 * Output: e
 * e is the first element that repeats
 * <p>
 * Input: str = “hello geeks”
 * Output: l
 * l is the first element that repeats
 */
public class FirstRepeatingCharacter {
    public static void main(String[] args) {
        String word = "geeksforgeeks";

        int[] charArray = new int[26];

        for (char ch : word.toCharArray()) {
            if(charArray[ch - 'a']==-1){
                System.out.println(ch);
                break;
            }
            charArray[ch - 'a']=-1;
        }

    }
}
