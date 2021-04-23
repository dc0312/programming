package practice.sort;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j);
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 1, 4};
        bubbleSort(arr);
    }
}
