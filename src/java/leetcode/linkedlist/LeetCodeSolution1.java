package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Flatten array
 * Ex: [1, 2, 3, [4, 5]] ---->  [1, 2, 3, 4, 5]
 *
 * @author DC
 */
public class LeetCodeSolution1 {

    public static void main(String[] args) {

        List<Object> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        List list = new ArrayList();
        list.add(4);
        list.add(5);
        lists.add(list);

        System.out.println(lists);

        List list1 = new ArrayList();
        for (Object customItem : lists) {
            if (customItem instanceof List) {
                for (Object o : (List) customItem) {
                    list1.add(o);
                }
            } else {
                list1.add(customItem);
            }
        }

        System.out.println(list1);

    }
}
