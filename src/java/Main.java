import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<>();
        names.put("DC", 29);
        names.put("AC", 27);
        names.put("LC", 50);
        //Comparator<Integer> byValue = (i1, i2) -> -i1.compareTo(i2);

        HashMap<String, Integer> sortedNames = names.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedNames);

        Map<String, Integer> sortedNamesByAge = new TreeMap<>((i1, i2) -> -i1.compareTo(i2));
        sortedNamesByAge.putAll(names);
        System.out.println(sortedNamesByAge);

        List<String> list = new ArrayList<>();
        list.add("acowa");
        list.add("a");
        list.add("cow");
        list.add("aow");
        System.out.println(list);

        Comparator<String> byName = (s1, s2) -> {
            int res = -(s1.length() - s2.length());
            if (res == 0) {
                return -s1.compareTo(s2);
            }
            return res;
        };
        List<String> sortedList = list.stream().sorted(byName).collect(Collectors.toList());
        System.out.println(sortedList);

    }
}
