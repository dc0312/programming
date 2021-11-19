package recursion;

public class PrintAllPermutations {
    public static void main(String[] args) {
        String word = "abc";
        printPermutations(word, "");
    }

    private static void printPermutations(String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            char rs = word.charAt(i);

            String lRos = word.substring(0, i);
            String rRos = word.substring(i + 1);

            String rWord = lRos + rRos;
            printPermutations(rWord, ans + rs);
        }
    }
}
