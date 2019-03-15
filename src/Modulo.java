import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Modulo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) set.add(input.nextInt() % 42);
        System.out.println(set.size());
    }
}
