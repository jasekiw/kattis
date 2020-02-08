import java.util.Scanner;

public class BatterUp {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var n = input.nextInt();
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            int val = input.nextInt();
            if(val >= 0) {
                sum += val;
                count++;
            }
        }
        System.out.println(sum / (double)count);
    }
}
