package helpers;

import java.util.Collection;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // guaranteed log(n)
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "World");
        treeMap.get(1);
        Collection<String> values = treeMap.values();
        treeMap.containsKey(1);
        treeMap.containsValue("World");
        System.out.println(treeMap.higherEntry(0));

    }
}
