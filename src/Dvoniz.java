import java.util.*;
public class Dvoniz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int s = input.nextInt();
        int[] a = new int[n];
        for(int i =0; i < n; i++){
            a[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++){
            int lastK = 0;
            boolean hitEnd = false;
            for(int currentK = 1; currentK <= (n - i) / 2; currentK++){
                int sum = 0;
                int sumB = 0;
                for(int j = 0; j < currentK; j++) {
                    if(sum + a[i + j] <= s && sumB + a[i + currentK + j] <= s) {
                        sum +=  a[i + j ];
                        sumB += a[i + currentK + j];
                    }
                    else {
                        hitEnd = true;
                        break;
                    }
                }
                if(hitEnd) break;
                lastK = currentK;
            }
            System.out.println(2 * lastK);
        }
    }
}
