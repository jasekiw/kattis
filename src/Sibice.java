import java.util.Scanner;

public class Sibice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = input.nextInt();
        int width = input.nextInt();
        int height = input.nextInt();
        double maxLength = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        for(int i = 0; i < matches; i++) {
            if(input.nextInt() > maxLength)
                System.out.println("NE");
            else
                System.out.println("DA");
        }
    }
}
