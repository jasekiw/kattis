import java.util.Scanner;

public class Aaah {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String john = in.nextLine();
        String doc = in.nextLine();

        if(john.length() >= doc.length())
            System.out.println("go");
        else
            System.out.println("no");
    }
}
