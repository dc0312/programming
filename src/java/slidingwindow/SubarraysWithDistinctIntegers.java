package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubarraysWithDistinctIntegers {
    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 1, 3};
        int k = 3;
        System.out.println("Result : " + solve(arr, k));
    }

    private static int solve(int[] arr1, int k) {
        List<Integer> arr = Arrays.stream(arr1).boxed().collect(Collectors.toList());
//        int begin = 0, end = 0, ans = -1;
//        Map<Integer, Integer> countMap = new HashMap<>();
//        int counter = 0;
//        while (end < arr.length) {
//            int cEnd = arr[end];
//            if (countMap.containsKey(cEnd)) {
//                countMap.put(cEnd, countMap.get(cEnd) + 1);
//            } else {
//                countMap.put(cEnd, 1);
//                counter++;
//            }
//
//            while (counter > k) {
//                int cBegin = arr[begin];
//                countMap.put(cBegin, countMap.get(cBegin) - 1);
//                if (countMap.get(cBegin) == 0) {
//                    counter--;
//                }
//                begin++;
//            }
//            if (counter == k) {
//                while (begin < arr.length && countMap.get(arr[begin]) > 1) {
//                    begin++;
//                    System.out.println("[" + begin + "," + end + "]");
//                    ans++;
//                }
//
//            }
//            end++;
//        }
//
//        return ans;
        int n = arr.size();
        Map<Integer, Integer> count = new HashMap<>();
        int diff = 0, l = 0, r = 0, ans = 0;
        for (r = 0; r < n; r++) {
            if (!count.containsKey(arr.get(r))) {
                k--;
                count.put((int) arr.get(r), 1);
            } else {
                count.put((int) arr.get(r), count.get(arr.get(r)) + 1);
            }
            if (k < 0) {
                count.put((int) arr.get(l), count.get(arr.get(l)) - 1);
                l++;
                k++;
                diff = 0;
            }
            if (k == 0) {
                while (l < n && count.get(arr.get(l)) > 1) {
                    count.put((int) arr.get(l), count.get(arr.get(l)) - 1);
                    l++;
                    ans++;
                    System.out.println("diff" + diff);
                }
                System.out.println("ans old" + ans);
                ans = ans + 1;
                System.out.println("ans+ new" + ans);
            }
        }

        return ans;
    }
}
