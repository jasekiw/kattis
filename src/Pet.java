import java.util.Scanner;

public class Pet {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int max = 0;
        int numLine = 0;
        for(int i = 1; i <= 5; i++)
        {
            String[] arr = input.nextLine().split("\\s+");
            int currentMax = 0;
            for(int x = 0; x < arr.length; x++)
                currentMax += Integer.parseInt(arr[x]);
            if(currentMax > max)
            {
                max = currentMax;
                numLine = i;
            }
        }
        System.out.println(numLine + " " + max);
    }
}
