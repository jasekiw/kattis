import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        int total = 0;
        int number = 0;
        for(int i = 0; i < n; i++)
        {
            total+=  in.nextInt();
            if(total <= t)
                number++;
        }
        System.out.println(number);
    }
}

