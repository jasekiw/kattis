import java.util.Scanner;

public class Doorman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSize = Integer.parseInt(scanner.nextLine());
        String queue = scanner.nextLine();
        int men = 0;
        int women = 0;
        int letIn = 0;
        while(queue.length() != 0) { // MWWMWMMWM
            String gender = queue.substring(0,1);
            int currentMen = men, currentWomen = women;
            if(gender.equals("M")) currentMen++; else  currentWomen++;

            if (Doorman.getDifference(currentMen, currentWomen) > maxSize) {
                if(Doorman.hasAlternateGenderIn2nd(queue, gender)) {
                    queue = queue.substring(1,2) + gender + queue.substring(2, queue.length());
                    continue;
                }
                else {
                    break;
                }

            }
            else {
                queue = queue.substring(1, queue.length());
                men = currentMen;
                women = currentWomen;
                letIn++;
            }
        }

        System.out.println(letIn);

    }

    public static boolean hasAlternateGenderIn2nd(String queue, String gender) {
        if(queue.length() >= 2) {
            String secondPersonGender = queue.substring(1,2);
            if(!secondPersonGender.equals(gender)) {
                return true;
            }
        }
        return false;
    }

    public static int getDifference(int men, int women) {
        return Math.abs(men - women);
    }
}
