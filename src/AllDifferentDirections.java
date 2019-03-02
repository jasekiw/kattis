import java.awt.*;
import java.util.Scanner;

public class AllDifferentDirections {

    static class Coord {
        public double x = 0;
        public double y = 0;
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        while(n!= 0) {
            Coord[] endPoints = new Coord[n];
            for(int nIndex = 0; nIndex < n; nIndex++) {


                Coord currentLocation = new Coord();
                currentLocation.x = input.nextDouble();
                currentLocation.y = input.nextDouble();


                input.next(); // read in the start command
                double currentDirection = input.nextDouble();
                String line = input.nextLine().trim();
                String[] parsed = line.split(" ");


                for (int i = 0; i < parsed.length; i += 2) {
                    String command = parsed[i];
                    double param = Double.parseDouble(parsed[i + 1]);
                    switch (command) {
                        case "walk": {
                            double height = Math.sin(Math.toRadians(currentDirection)) * param;
                            double width = Math.cos(Math.toRadians(currentDirection)) * param;
                            currentLocation.x += width;
                            currentLocation.y += height;
                            break;
                        }
                        case "turn": {
                            currentDirection += param;
                            break;
                        }
                    }
                }

                endPoints[nIndex] = currentLocation;
            }

            Coord averagePoint = new Coord();
            for(int i = 0; i < endPoints.length; i++) {
                averagePoint.x += endPoints[i].x;
                averagePoint.y += endPoints[i].y;
            }
            averagePoint.x = averagePoint.x / endPoints.length;
            averagePoint.y = averagePoint.y / endPoints.length;

            double longestDistance = 0;
            for(int i = 0; i < endPoints.length; i++) {
                double distance = distance(averagePoint, endPoints[i]);
                if(longestDistance < distance) {
                    longestDistance = distance;
                }
            }
            System.out.println(averagePoint.x + " " + averagePoint.y + " " + longestDistance);

            n = input.nextInt();
        }

    }


    static double distance(Coord coord1, Coord coord2) {
        double distanceX = Math.abs(coord1.x - coord2.x);
        double distanceY = Math.abs(coord1.y - coord2.y);
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);


    }


}
