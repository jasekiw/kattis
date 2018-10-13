import java.math.BigInteger;
import java.util.Scanner;

public class AnotherCandies {
    public static void main(String[] args) {

        Scanner inputSCanner = new Scanner(System.in);
        int testCases;
        testCases = inputSCanner.nextInt();
        for(int notUsing =0; notUsing < testCases; notUsing++)
        {
            int numOfKids = inputSCanner.nextInt();
            BigInteger total = BigInteger.valueOf(0);
            for(int i =0; i < numOfKids; i++)
                total = total.add(BigInteger.valueOf(inputSCanner.nextLong()));
            if(total.mod(BigInteger.valueOf(numOfKids)).equals(BigInteger.ZERO))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}