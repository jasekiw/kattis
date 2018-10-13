import java.util.Scanner;

public class QuickBrownFox {
    public static void main(String[] args) {
        int aInt = (int)'a';
        Scanner inputScanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(inputScanner.nextLine());
        for(int line =0; line < numberOfLines; line++) // cycle through each input line
        {
            String inputLine = inputScanner.nextLine().toLowerCase();
            boolean[] alphabetArray = new boolean[26];
            for(int cIndex = 0; cIndex < inputLine.length(); cIndex++)
            {
                char c = inputLine.charAt(cIndex);
                if((int)c - aInt >= 0 && (int)c - aInt < 26)
                    alphabetArray[(int)c - aInt] = true;
            }
            boolean hasAlphabet = true;
            String missingCharacters = "";
            for( int i = 0; i < alphabetArray.length; i++ )
                if(!alphabetArray[i])
                {
                    hasAlphabet = false;
                    missingCharacters += (char) (i + aInt);
                }
            if(hasAlphabet)
                System.out.println("pangram");
            else
                System.out.println("missing " + missingCharacters);
        }
    }
}