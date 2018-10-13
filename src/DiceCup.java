import java.util.*;
public class DiceCup {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numFacesDice1 = inputScanner.nextInt();
        int numFacesDice2 = inputScanner.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>(numFacesDice1 * numFacesDice2);
        // O(n^2)
        int maxChances = 0;
        Integer maxKey = -1;
        for(int x = 1; x <= numFacesDice1; x++) {
            for (int y = 1; y <= numFacesDice2; y++) {
                Integer key = x + y;
                if(map.containsKey(x + y)) {
                    Integer currentValue = map.get(key);
                    currentValue++;
                    if(currentValue > maxChances) {
                        maxChances = currentValue;
                        maxKey = key;
                    }

                    map.replace(key, currentValue);
                } else  {
                    if(1 > maxChances) {
                        maxKey = key;
                        maxChances = 1;
                    }
                    map.put(key, 1); // add into the map
                }
            }
        }
        ArrayList<Integer> greatestProbabilities = new ArrayList<>();
        int finalMaxChances = maxChances;
        map.forEach((Integer key, Integer value) -> {
            if(value >= finalMaxChances)
                greatestProbabilities.add(key);
        });

        greatestProbabilities.sort((Integer o1, Integer o2) ->   o1-o2);
        greatestProbabilities.forEach(System.out::println);
    }
}
