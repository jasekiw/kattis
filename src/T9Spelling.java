import java.util.HashMap;
import java.util.Scanner;

public class T9Spelling {

    public static void main(String[] args) {
        HashMap<Character, String> numpad = new HashMap<>();
        numpad.put('A', "2");
        numpad.put('B', "22");
        numpad.put('C', "222");
        numpad.put('D', "3");
        numpad.put('E', "33");
        numpad.put('F', "333");
        numpad.put('G', "4");
        numpad.put('H', "44");
        numpad.put('I', "444");
        numpad.put('J', "5");
        numpad.put('K', "55");
        numpad.put('L', "555");
        numpad.put('M', "6");
        numpad.put('N', "66");
        numpad.put('O', "666");
        numpad.put('P', "7");
        numpad.put('Q', "77");
        numpad.put('R', "777");
        numpad.put('S', "7777");
        numpad.put('T', "8");
        numpad.put('U', "88");
        numpad.put('V', "888");
        numpad.put('W', "9");
        numpad.put('X', "99");
        numpad.put('Y', "999");
        numpad.put('Z', "9999");
        numpad.put(' ', "0");

        Scanner inputScanner = new Scanner(System.in);
        int cases = Integer.parseInt(inputScanner.nextLine());

        for(int i =1; i <= cases; i++)
        {
            String output = "";
            String input = inputScanner.nextLine().toUpperCase();
            for(int charNum = 0; charNum < input.length(); charNum++)
            {
                String nextSequence = numpad.get(input.charAt(charNum));
                if(output.length() > 0 && output.charAt(output.length() - 1) != nextSequence.charAt(0))
                    output += nextSequence;
                else
                    output += " " + nextSequence;
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}
