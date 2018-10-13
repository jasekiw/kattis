import java.util.Scanner;

public class Apaxiaaaaaaaaaaaans {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextLine();
        String output = "";
        for(int i =0; i < input.length(); i++)
        {
            if(i == 0)
                output += input.charAt(i);
            else if(input.charAt(i - 1) != input.charAt(i))
                output += input.charAt(i);
        }
        System.out.println(output);
    }
}