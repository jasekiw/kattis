import java.util.Scanner;

public class Froggie {
    static class Lane {
        int offset;
        int carInterval;
        int carSpeed;
        int direction;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLanes = scanner.nextInt();
        int laneWidth = scanner.nextInt();
        Lane[] lanes = new Lane[numberOfLanes];
        scanner.nextLine();
        for(int lane = 0; lane < numberOfLanes; lane++) {
            lanes[lane] = new Lane();
            lanes[lane].offset = scanner.nextInt();
            lanes[lane].carInterval = scanner.nextInt();
            lanes[lane].carSpeed = scanner.nextInt();
            lanes[lane].direction = (lane % 2) == 0 ? 1: -1;
            scanner.nextLine();
        }
        int frogStartingPos = scanner.nextInt();
        String moves = scanner.nextLine().trim();
        // froggie x and y.
        int fx = frogStartingPos, fy = -1;

        int time = 0;
        while(moves.length() != 0) {
            time++;
            String move = moves.substring(0,1);
            switch (move) {
                case "U": fy++; break;
                case "D": fy--; break;
                case "L": fx--; break;
                case "R": fx++; break;
            }

            int laneIndex = lanes.length - 1 - fy;
            if(laneIndex < lanes.length && laneIndex >= 0) {
                Lane lane =  lanes[laneIndex];
                if(isSquashed(fx, fy, lane, laneWidth, time)) {
                    System.out.println("squish");
                    System.exit(0);
                }
            }

            moves = moves.substring(1,moves.length());
        }

        if(fy < numberOfLanes) {
            System.out.println("squish");
            System.exit(0);
        }

        System.out.println("safe");
    }

    static boolean isSquashed(int fx, int fy, Lane lane, int width, int time) {
        // if the lane is moving left then we will act like froggie is based at the end so we don't have to adjust all the checks
        if(lane.direction == -1) {
            fx = width - fx - 1;
        }
        time--;

        int actualPos = lane.offset;
        actualPos += lane.carSpeed * time;
        while(actualPos < width)
            actualPos += lane.carInterval;
        while(actualPos >= fx)
            actualPos -= lane.carInterval;

        if(lane.carSpeed == 0) {
            if(fx == actualPos + lane.carInterval)
                return true;
            return false;
        }

        int minMoved = Math.min(1, lane.carSpeed);
        int moved = lane.carSpeed;
        if (actualPos + minMoved <= fx && fx <= actualPos + moved)
            return true;
        return false;
    }


}


