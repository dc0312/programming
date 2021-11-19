package recursion;

import java.util.ArrayList;

public class GetKeyPadCombination {
    static String[] combArr = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) {
        ArrayList<String> keyPadList = getKeyPadCombination("563");
        System.out.println("Result " + keyPadList);
    }

    private static ArrayList<String> getKeyPadCombination(String word) {

        if (word.length() == 0) {
            ArrayList bAns = new ArrayList();
            bAns.add("");
            return bAns;
        }

        String ch = word.substring(0, 1);
        String subWord = word.substring(1);
        ArrayList<String> res = getKeyPadCombination(subWord);
        ArrayList<String> myRes = new ArrayList<>();
        for (char c : combArr[Integer.parseInt(ch)].toCharArray()) {
            for (String w : res) {
                myRes.add(c + w);
            }
        }

        return myRes;
    }
}
