package dp;

/*
Count of subsets sum with a Given sum
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}
* */
public class CountSubsetSum {

    private static int countSubsetSum(int arr[], int sum, int n) {
        int[][] T = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    T[i][j] = 0;
                }
                if (j == 0) {
                    T[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    T[i][j] = T[i - 1][j - arr[i - 1]] + T[i - 1][j];
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++)
                System.out.printf("%4d", T[i][j]);
            System.out.printf("\n");
        }
        return T[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int sum = 6;
        System.out.println("Result : " + countSubsetSum(arr, sum, arr.length));
    }
}
