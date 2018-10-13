import java.util.Scanner;

public class Yoda {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String firstNum = inputScanner.nextLine();
        String secondNum = inputScanner.nextLine();
        int differenceInLength = firstNum.length() - secondNum.length();
        String appending = "";
        for(int i = 0; i < Math.abs(differenceInLength); i++)
            appending += "0";
        if(differenceInLength < 0)
            firstNum = appending + firstNum;
        else if(differenceInLength > 0)
            secondNum = appending + secondNum;

        String firstNumOutput = "";
        String secondNumOutput = "";
        for(int i = 0; i < firstNum.length(); i++) {
            int firstDigit = Integer.parseInt(firstNum.substring(i, i + 1));
            int secondDigit = Integer.parseInt(secondNum.substring(i, i + 1));
            if(firstDigit > secondDigit)
                firstNumOutput += firstDigit;
            else if(firstDigit < secondDigit)
                secondNumOutput += secondDigit;
            else {
                firstNumOutput += firstDigit;
                secondNumOutput += secondDigit;
            }
        }
        if(firstNumOutput.equals(""))
            System.out.println("YODA");
        else
            System.out.println(Integer.parseInt(firstNumOutput));
        if(secondNumOutput.equals(""))
            System.out.println("YODA");
        else
            System.out.println(Integer.parseInt(secondNumOutput));
    }

}
