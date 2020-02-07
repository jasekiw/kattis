import java.util.Scanner;

public class HalfACookie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x  = input.nextInt();
        int y  = input.nextInt();
        int n  = input.nextInt();
        for(int i = 1; i <= n; i++) {
           if(i % x == 0 &&  i % y == 0) {
               System.out.println("FizzBuzz");
           } else if(i % x == 0) {
                System.out.println("Fizz");
            } else if(i % y == 0) {
                System.out.println("Buzz");
            } else {
               System.out.println(i);
           }
        }

    }
}
