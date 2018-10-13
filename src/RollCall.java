import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RollCall {
    private static ArrayList<String> names = new ArrayList<>();
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        while (inputScanner.hasNextLine())
            names.add(inputScanner.nextLine());
        Collections.sort(names, (o1, o2) -> {
            String[] name1 = o1.split("\\s+");
            String[] name2 = o2.split("\\s+");
            if (name1[1].equals(name2[1]))
                return name1[0].compareTo(name2[0]);
            else
                return name1[1].compareTo(name2[1]);
        });

        for (String s : names) {
            String firstName = s.split("\\s+")[0];
            if(containsFirstName(s))
                System.out.println(s);
            else
                System.out.println(firstName);
        }

    }


    static boolean containsFirstName(String name)
    {
        String[] inputName = name.split("\\s+");
        for (String s :names)
        {
            String[] splitName = s.split("\\s+");
            if(splitName[0].equals(inputName[0]) && !inputName[1].equals(splitName[1]))
                return true;
        }
        return false;
    }
}
