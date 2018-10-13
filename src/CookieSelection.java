import java.util.ArrayList;
import java.util.Scanner;

public class CookieSelection {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        //TreeMap
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(line.equals("#")) {
                int diameter = CookieSelection.getMedian(list);
                System.out.println(diameter);
            }
            else {
                int diameter = Integer.parseInt(line);
                CookieSelection.insertSorted(list, diameter);
            }
        }
    }


    static void insertSorted(ArrayList<Integer> list, int diameter) {
        for(int i = 0; i < list.size(); i++)
        {
            if( list.get(i) > diameter)   {
                list.add(i, diameter);
                return;
            }
        }
        list.add(diameter);
    }

    static int getMedian(ArrayList<Integer> list) {
        boolean isEven = list.size() % 2 == 0;
        int index;
        if(isEven)
            index = (list.size() / 2) + 1;
        else
            index = (list.size() + 1) / 2;
        index--;
        return list.remove(index);
    }



}
