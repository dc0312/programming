package MultiThreading;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListMain {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.ensureCapacity(500000);
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(arrayList);


        long startTime = System.nanoTime();
        copyOnWriteArrayList.add(500001);
        long endTime = System.nanoTime();
        System.out.println("Copy ==>" + (endTime - startTime));

        long startTime_al = System.nanoTime();
        arrayList.add(500001);
        long endTime_al = System.nanoTime();
        System.out.println("Copy ==>" + (endTime_al - startTime_al));
    }
}
