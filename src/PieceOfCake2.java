import java.util.Scanner;

public class PieceOfCake2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        int v = scanner.nextInt();
        int height = h > (n / 2.0) ? h : n - h;
        int width =   v > (n / 2.0) ? v : n - v;
        System.out.println(width * height * 4);
    }
}
