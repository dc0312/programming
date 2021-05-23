package recursion;

import java.util.HashSet;
import java.util.Set;

public class PrintAllSubstrings {
    public static void main(String[] args) {
        String s = "cac";

        findSubString(s);
    }

    private static int findSubString(String s) {
        Set set = new HashSet();
        set.add(s);
        findSubString(s, set);
        set.stream().forEach(System.out::println);
        return set.size();
    }

    private static void findSubString(String s, Set set) {
        if (s.length() == 0) {
            return;
        }
        for (int i = 1; i < s.length(); i++) {
            set.add(s.substring(i));
            set.add(s.substring(0, i));
            findSubString(s.substring(i), set);
            findSubString(s.substring(0, i), set);
        }
    }
}
