package leetcode.slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
* */
public class LeetCode239SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = maxSlidingWindow(arr, k);
        Arrays.stream(ans).forEach(System.out::println);
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {

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
