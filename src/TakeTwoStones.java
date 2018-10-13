import java.util.*;

public class TakeTwoStones {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if(in % 2 == 0)
            System.out.println("Bob");
        else
            System.out.println("Alice");
    }

}
