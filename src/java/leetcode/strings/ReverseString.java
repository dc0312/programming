package leetcode.strings;

public class ReverseString {
    public static void main(String[] args) {
        String word = "word";
        System.out.println(rev(word));
    }

    private static String rev(String word) {
        if(word == null || word.length()==1){
            return word;
        }

        String res = rev(word.substring(1));
        return new StringBuilder().append(res).append(word.substring(0,1)).toString();
    }
}
