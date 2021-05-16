package neew;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = maxSubArray(arr, k);
        Arrays.stream(ans).forEach(System.out::println);
    }

    private static int[] maxSubArray(int[] arr, int k) {
        int i = 0, j = 0;
        Deque q = new ArrayDeque();
        int[] ans = new int[arr.length - k + 1];
        while (j < arr.length) {
            while (!q.isEmpty() && arr[j] > (int) q.peekLast()) {
                q.pollLast();
            }
            q.addLast(arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                ans[j - k + 1] = (int) q.peekFirst();
                if (arr[i] == (int) q.peekFirst()) {
                    q.pollFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
