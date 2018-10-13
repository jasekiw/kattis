import java.util.*;

public class ArmyStrengthHard {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = inputScanner.nextInt();
        long start = System.currentTimeMillis();
        for(int testCase = 0; testCase < numOfTestCases; testCase++)
        {
            inputScanner.nextLine();
            int godzillaTeamMembers = inputScanner.nextInt();
            int mechaGodzillaTeamMembers = inputScanner.nextInt();
            inputScanner.nextLine();
            int maxStrengthGodzilla = 0;
            for(int i = 0; i < godzillaTeamMembers; i++)
            {
                int strength = inputScanner.nextInt();
                if(strength > maxStrengthGodzilla)
                    maxStrengthGodzilla = strength;
            }
            int maxStrengthMechaGodzilla = 0;
            for(int i = 0; i < mechaGodzillaTeamMembers; i++)
            {
                int strength = inputScanner.nextInt();
                if(strength > maxStrengthMechaGodzilla)
                    maxStrengthMechaGodzilla = strength;
            }

            if(maxStrengthMechaGodzilla > maxStrengthGodzilla)
                System.out.println("MechaGodzilla");
            else
                System.out.println("Godzilla");

        }

    }
}
