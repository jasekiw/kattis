import java.math.BigInteger;
import java.util.Scanner;

public class LockedTreasure {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int i = 0; i < cases; i++)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(factorial(n).divide(factorial(m).multiply(factorial(n - m)))
            );
        }
    }

    private static BigInteger factorial(int num) {
        BigInteger total = BigInteger.valueOf(num);
        for(int i = num - 1; i > 1; i--)
            total = total.multiply(BigInteger.valueOf(i));
        return total;
    }

}
