package leetcode.list;

import java.util.*;

/*
* Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum.
*  If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.*/
public class LeetCode599MinIndex {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> listMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            listMap.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer index = listMap.get(list2[i]);
            if (null != index && index + i < min) {
                res.clear();
                res.add(list2[i]);
                min = index + i;
            } else if (null != index && index + i == min) {
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Burger King", "Tapioca Express", "Shogun"};
        String[] commonList = findRestaurant(list1, list2);
        System.out.println("com : " + Arrays.asList(commonList));
    }

}
