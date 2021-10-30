package sliding;

import java.util.LinkedList;

public class MaxOfSubArraySizeK {
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        logic(arr,k);
    }

    private static void logic(int[] arr, int k) {
        int i =0, j =0;
        LinkedList<Integer> q = new LinkedList<>();

        while(j < arr.length){

            if(!q.isEmpty()){
                while (!q.isEmpty() && arr[j] > q.getLast()){
                    q.removeLast();
                }
            }

            q.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }else{
                System.out.print(q.getFirst()+",");
                if(arr[i]==q.getFirst()){
                    q.removeFirst();
                }
                i++;
                j++;
            }
        }
    }
}
