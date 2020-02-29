import java.util.*;

public class Bijele {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] requiredNums = new int[]{1, 1, 2, 2, 2, 8};
        for (int requiredNum : requiredNums) {
            System.out.print(requiredNum - scanner.nextInt() + " ");
        }
    }
}