import java.util.Scanner;

public class MixedFractions {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        while(inputScanner.hasNextLine())
        {
            int numerator =  inputScanner.nextInt();
            int denominator =  inputScanner.nextInt();
            if(numerator == 0 && denominator == 0)
                System.exit(0);
            int wholeNum = numerator /denominator;
            int leftOver = numerator % denominator;
            System.out.println(wholeNum + " " + leftOver + " / " + denominator);
        }
    }
}
