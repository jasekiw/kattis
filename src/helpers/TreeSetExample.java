package helpers;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        // get lowest number greater than 2
        treeSet.higher(2);
        // get highest number lower than 2
        treeSet.lower(2);
        treeSet.contains(2); // true
        treeSet.remove(1);
        // iterate in ascending order
        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Integer value = (Integer)iterator.next();
        }
        // adding duplicates will return false
        boolean changed = treeSet.add(2);
        // iterate in descending order
        Iterator descendingIterator = treeSet.descendingIterator();
        while(descendingIterator.hasNext()) {
            Integer value = (Integer)descendingIterator.next();
        }

    }
}
