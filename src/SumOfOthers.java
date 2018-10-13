import java.util.Scanner;

public class SumOfOthers {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        while(inputScanner.hasNextLine())
        {
            String nextLine = inputScanner.nextLine();
            String[] inputLine = nextLine.split("\\s+");
            int[] inputNumbers = new int[inputLine.length];
            for(int i=0; i < inputNumbers.length; i++)
                inputNumbers[i] = Integer.parseInt(inputLine[i]);

            int answer = 0;
            for(int sumIndex = 0; sumIndex < inputNumbers.length; sumIndex++)
            {
                int sum = 0;
                for(int i =0; i < inputNumbers.length; i++)
                {
                    if(i != sumIndex)
                        sum += inputNumbers[i];
                }
                if(sum == inputNumbers[sumIndex])
                    answer = inputNumbers[sumIndex];
            }
            System.out.println(answer);
        }
    }
}
