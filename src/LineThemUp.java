import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LineThemUp {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int numLines = Integer.parseInt(input.nextLine());
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> arr3 = new ArrayList<>();
        for(int currentLine = 0; currentLine < numLines; currentLine++)
        {
            String line = input.nextLine();
            arr1.add(line);
            arr2.add(line);
            arr3.add(line);
        }
        Collections.sort(arr1);

        arr2.sort((arg0, arg1) -> arg1.compareTo(arg0));

        if(arr3.equals(arr1))
            System.out.println("Increasing".toUpperCase());
        else if(arr3.equals(arr2))
            System.out.println("Decreasing".toUpperCase());
        else
            System.out.println("Neither".toUpperCase());


    }
}