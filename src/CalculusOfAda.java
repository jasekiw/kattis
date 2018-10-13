import java.util.ArrayList;
import java.util.Scanner;

public class CalculusOfAda {
    public static void main(String[] args)
    {
        Scanner inScanner =new Scanner(System.in);
        int n = inScanner.nextInt();
        int[] currentSet = new int[n];
        ArrayList<Integer> ends = new ArrayList<>();
        for(int i = 0; i < n; i++)
            currentSet[i] = inScanner.nextInt();
        ends.add(currentSet[currentSet.length - 1]);
        boolean numbersNotEqual = true;
        int currentDepth = 1;
        while(numbersNotEqual && currentSet.length > 1)
        {
            currentSet = getSplits(currentSet);
            ends.add(currentSet[currentSet.length - 1]);
            if(areEqualThroughout(currentSet))
                numbersNotEqual = false;
            else
                currentDepth++;
        }
        int nextNumber = 0;
        for(int i =0; i < ends.size(); i++)
            nextNumber += ends.get(i);

        System.out.println(currentDepth + " " + nextNumber);

    }

    /**
     * @requires numbers.length > 1
     * @param numbers the numbers to split
     * @return the spit of numbers
     */
    private static int[] getSplits(int[] numbers)
    {
        int[] newNumbers = new int[numbers.length - 1];
        for(int i = 0; i < numbers.length; i++)
            if(i+ 1 < numbers.length)
                newNumbers[i] =  numbers[i + 1] - numbers[i];
        return newNumbers;
    }

    private static boolean areEqualThroughout(int[] numbers) {
        boolean sameThroughout = true;
        for(int i = 0; i < numbers.length; i++)
            if(i > 0 && numbers[i - 1] != numbers[i])
                sameThroughout = false;
        return sameThroughout;

    }

}
