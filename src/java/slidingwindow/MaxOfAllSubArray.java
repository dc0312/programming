package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example:

Input 1:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3
Output 1:
    C = [3, 3, 5, 5, 6, 7]
Input 2:
int arr[] = {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
        int k = 9;
Output 2:
    745 745 775 775 876 876 876 876 876 876 876 951 951 951 951 951 951 951 951 951 882 882 882 882 935 935 935 935 935 935 935 935 935 892 892 892 900 900 900 937 937 937
**/
public class MaxOfAllSubArray {

    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 1, 6, 3, 8};
        int k = 3;

        maxInAllSubArray(arr, k);
    }

    private static void maxInAllSubArray(int[] arr, int k) {
        int i = 0, j = 0;
        Deque queue = new ArrayDeque();

        while (j < arr.length) {
            if (!queue.isEmpty()) {
                while (!queue.isEmpty() && arr[j] > (int) queue.peekLast()) {
                    queue.pollLast();
                }
            }
            queue.addLast(arr[j]);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                System.out.print(queue.peekFirst() + " ");

                if (arr[i] == (int) queue.peek()) {
                    queue.poll();
                }
                i++;
                j++;
            }
        }
    }
}
