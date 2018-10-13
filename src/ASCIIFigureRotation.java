import java.util.Scanner;

public class ASCIIFigureRotation {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numbers = Integer.parseInt(inputScanner.nextLine());
        boolean isFirstMatrix = true;

        while(numbers != 0) {
            if(!isFirstMatrix)
                System.out.println();
            isFirstMatrix = false;
            char[][] board = new char[100][numbers];

            for(int i  = 0; i < numbers; i++)
            {
                String line = inputScanner.nextLine();
                for(int charIndex = 0; charIndex < line.length(); charIndex++ )
                {
                    char character = line.charAt(charIndex);
                    if(character == '-')
                        character = '|';
                    else if(character == '|')
                        character = '-';

                    board[charIndex][(numbers - 1) - i] = character;
                }

            }
            outputBoard(board);
            numbers = Integer.parseInt(inputScanner.nextLine());
        }

    }


    static void outputBoard(char[][] board) {
        for(int x = 0; x < board.length; x++) {
            String line = "";
            boolean hitNonNull = false;
            boolean hitNonSpace = false;
            for(int y = board[x].length - 1; y >= 0; y--) {

                if(board[x][y] == ' ' && !hitNonSpace)
                    board[x][y] = 0;
                if(board[x][y] != ' ' && board[x][y] != 0)
                    hitNonSpace = true;
                if(board[x][y] == 0 && hitNonNull)
                    board[x][y] = ' ';
                if(board[x][y] != 0)
                    hitNonNull = true;
                if(board[x][y] != 0)
                    line = board[x][y] + line;
            }

            if(!line.equals(""))
                System.out.println(line);
        }
    }
}