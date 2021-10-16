package dp;

/*
* Minimum number of deletions and insertions to transform one string into another
Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
Example:
Input : str1 = "geeksforgeeks", str2 = "geeks"
Output : Minimum Deletion = 8
         Minimum Insertion = 0 */
public class MinimumNumberOfInsertDel {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "geeks";

//        String s1 = "heap";
//        String s2 = "pea";

        minNoOfInsDel(s1, s2);
    }

    private static void minNoOfInsDel(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] T = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                } else {
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        int longSubLen = T[m][n];

        int numberOfDel = m - longSubLen;
        int numberOfIns = n - longSubLen;

        System.out.println("Insertion : " + numberOfIns);
        System.out.println("Deletion : " + numberOfDel);
    }
}
