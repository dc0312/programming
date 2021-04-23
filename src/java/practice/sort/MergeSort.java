package practice.sort;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {12, 30, -3, 7, 20, 40, -22};

        mergeSort(arr, 0, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        //This condition means that we have to break it once we have only one element.That means
        // One element is always sort.
        //This is the break condition.
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        //to make it more efficient
        /*if(arr[mid-1]<= arr[mid]){
            return;
        }*/
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int temp[] = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i < mid) {
            temp[tempIndex++] = arr[i++];
        }
        System.arraycopy(temp, 0, arr, start, tempIndex);
    }
}
