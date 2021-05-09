package slidingwindow;

public class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {
        int sum = 0;
        int i = 0, j = 0;

        int min = Integer.MAX_VALUE;

        while (j < arr.length) {
            sum = sum + arr[j];
            if (sum < S) {
                j++;
            } else {
                min = Math.min(min, j - i + 1);
                sum = sum - arr[i];
                i++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int s = 7;

        System.out.println("Result : " + findMinSubArray(s, arr));
    }
}
