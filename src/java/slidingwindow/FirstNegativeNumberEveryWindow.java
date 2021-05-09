package slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Example:

Input:
2
5
-8 2 3 -6 10
2
8
12 -1 -7 8 -15 30 16 28
3

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0
* */
public class FirstNegativeNumberEveryWindow {

    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        firstNegativeNumber(arr, k);
    }

    private static void firstNegativeNumber(int[] arr, int k) {
        int i = 0, j = 0;
        Queue queue = new LinkedList();

        while (j < arr.length) {
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (queue.isEmpty()) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(queue.peek() + " ");
                }

                if (!queue.isEmpty() && arr[i] == (int) queue.peek()) {
                    queue.poll();
                }
                i++;
                j++;
            }
        }

    }
}
