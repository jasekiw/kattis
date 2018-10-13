import java.util.Scanner;

public class Planina {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int iteration = input.nextInt();
        int numOnOneSide = (int)Math.pow(2, iteration);
        int points = (int)Math.pow(numOnOneSide + 1, 2);
        System.out.println(points);
    }
}
