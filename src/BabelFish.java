import java.util.HashMap;
import java.util.Scanner;

public class BabelFish {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        Scanner inputScanner = new Scanner(System.in);
        boolean fillingDictionary = true;
        while(inputScanner.hasNextLine())
        {
            String input = inputScanner.nextLine();
            if(input.length() == 0)
            {
                fillingDictionary = false;
                continue;
            }

            if(fillingDictionary)
            {
                String[] words = input.split("\\s+");
                dictionary.put(words[1], words[0]);
            }
            else
            {
                String output = dictionary.get(input.trim());
                if(output == null)
                    System.out.println("eh");
                else
                    System.out.println(output);
            }
        }
    }
}
