import java.util.Scanner;

public class ColdPuterScience {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int numBelow0 = 0;
        for(int i = 0; i < n; i++) {
            int temp = input.nextInt();
            if(temp < 0)
                numBelow0++;
        }
        System.out.println(numBelow0);
    }
}
