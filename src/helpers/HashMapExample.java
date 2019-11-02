package helpers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // guaranteed log(n)
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Hello", "World");
        hashMap.get("Hello");
        Collection<String> values = hashMap.values();
        Set<String> Keys = hashMap.keySet();
        hashMap.containsKey("Hello");
        hashMap.containsValue("World");
    }
}
