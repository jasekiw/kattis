import java.util.Date;
import java.util.Scanner;

public class Eligibility {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());
        for(int i =0; i < cases; i++)
        {
            String[] input = in.nextLine().split("\\s");
            String name = input[0];
            Date beginDate = new Date(input[1]);
            Date birthday = new Date(input[2]);
            int courses = Integer.parseInt(input[3]);

            if(!beginDate.before(new Date("01/01/2010")))
                System.out.println(name + " " + "eligible");
            else if(!birthday.before(new Date("01/01/1991") ) )
                System.out.println(name + " " + "eligible");
            else if(courses > 40)
                System.out.println(name + " " + "ineligible");
            else
                System.out.println(name + " " + "coach petitions");
        }
    }

}
