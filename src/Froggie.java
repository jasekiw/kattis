import java.awt.*;
import java.util.Scanner;

public class Froggie {
    static class Lane {
        int firstCarOffset;
        int carInterval;
        int carSpeed;
    }
    static class Car {
        int lastPos;
        int currentPos;
        public boolean cycled() {
            return currentPos < lastPos;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLanes = scanner.nextInt();
        int laneWidth = scanner.nextInt();
        Lane[] lanes = new Lane[numberOfLanes];
        scanner.nextLine();
        for(int lane = 0; lane < numberOfLanes; lane++) {
            lanes[lane] = new Lane();
            lanes[lane].firstCarOffset = scanner.nextInt();
            lanes[lane].carInterval = scanner.nextInt();
            lanes[lane].carSpeed = scanner.nextInt();
            scanner.nextLine();
        }
        int frogStartingPos = scanner.nextInt();
        String moves = scanner.nextLine().trim();
        Point pos = new Point(frogStartingPos, -1);
        int time = 0;
        while(moves.length() != 0) {
            time++;
            String move = moves.substring(0,1);
            if(move.equals("U")) {
                pos = new Point(pos.x, pos.y + 1);
            }
            else if(move.equals("D")) {
                pos = new Point(pos.x, pos.y - 1);
            }
            else if(move.equals("L")) {
                pos = new Point(pos.x - 1, pos.y);
            }
            else if(move.equals("R")) {
                pos = new Point(pos.x - 1, pos.y);
            }
            Froggie.normalizeFrogPosition(pos, laneWidth);
            int laneIndex = lanes.length - 1 - pos.y;
            if(laneIndex < lanes.length && laneIndex >= 0) {
                Lane lane =  lanes[laneIndex];
                int direction = ((lanes.length - 1 - laneIndex) % 2) == 0 ? 1: -1;
                if(isSquashed(pos, lane, laneWidth, time, direction)) {
                    System.out.println("squish");
                    System.exit(0);
                }
            }

            moves = moves.substring(1,moves.length());
        }

        if(pos.y < numberOfLanes) {
            System.out.println("squish");
            System.exit(0);
        }

        System.out.println("safe");
    }

    static boolean isSquashed(Point location, Lane lane, int width, int time, int direction) {
        int carsPerLane = (int)Math.floor((width - 1 - lane.firstCarOffset) / (double)lane.carInterval);
        carsPerLane++; // always has one car in it.
        Car[] carPositions = new Car[carsPerLane];
        for(int carIndex = 0; carIndex < carsPerLane; carIndex++) {
            Car car = new Car();
            car.currentPos = wrapPosition((lane.firstCarOffset + (carIndex * lane.carInterval) + (time * direction * lane.carSpeed)), width);
            car.lastPos = wrapPosition((lane.firstCarOffset + (carIndex * lane.carInterval) + ((time - 1) * direction * lane.carSpeed)), width);

            carPositions[carIndex] = car;
        }

        if(direction == 1) { // right
            for(int carIndex = carsPerLane - 1; carIndex >= 0; carIndex--)
                if(hitCar(carPositions, carIndex, direction, lane, location))
                    return true;
        }
        else { // left
            for(int carIndex = 0; carIndex < carsPerLane; carIndex++)
                if(hitCar(carPositions, carIndex, direction, lane, location))
                    return true;
        }

        return false;
    }

    static boolean hitCar(Car[] carPositions, int carIndex, int direction, Lane lane, Point location) {
        Car car = carPositions[carIndex];
//        if(car.currentPos == car.lastPos)
//            return false; // non-moving car
        // check if car should be included in the set.
        if(!shouldIncudeCare(carPositions, carIndex, direction, lane))
            return false;
//        if(car.currentPos == car.lastPos && location.x == car.currentPos)
//            return true;

        if(car.currentPos < car.lastPos && direction == 1) { // car looped
            if(location.x > car.lastPos || location.x <= car.currentPos)
                return true;
        }
        else if(direction == 1) { // car didn't loop
            if(location.x > car.lastPos && location.x <= car.currentPos)
                return true;
        }
        else if(car.currentPos > car.lastPos && direction == -1) { // looped left
            if(location.x < car.lastPos || location.x >= car.currentPos)
                return true;
        }
        else if(direction == -1) { // didn't loop left
            if(location.x < car.lastPos && location.x >= car.currentPos)
                return true;
        }
        return false;
    }
    static void normalizeFrogPosition(Point pos, int laneWidth) {
        if(pos.x < 0) {
            pos.x = laneWidth - Math.abs(pos.x);
        }
        else if(pos.x > laneWidth - 1) {
            pos.x =  pos.x % laneWidth;
        }
    }

    static <T> T getPrevious(T[] carPositions, int index) {
        if(index - 1 < 0){
            return carPositions[carPositions.length - 1];
        }
        return carPositions[index - 1];
    }
    static <T> T getNext(T[] carPositions, int index) {
        if(index + 1 >= carPositions.length) {
            return  carPositions[0];
        }
        return carPositions[index + 1];
    }

    static int wrapPosition(int position, int width) {
        if(position >= width)
           return position % width;
        while(position < 0)
            position = width - Math.abs(position);
        return position;
    }

    static boolean shouldIncudeCare(Car[] carPositions, int carIndex, int direction, Lane lane) {
        Car car = carPositions[carIndex];
        if(carPositions.length == 1)
            return true;
        if(direction == 1) { // right
            Car nextCar = getNext(carPositions, carIndex);
            // the car cycled.
            if(nextCar.currentPos > car.currentPos && Math.abs(nextCar.currentPos - car.currentPos) != lane.carInterval) {
                return false;
            }

        }
        else if(direction == -1) { // left
            Car previous = getPrevious(carPositions, carIndex);
            if(previous.currentPos < car.currentPos && Math.abs(car.currentPos - previous.currentPos ) != lane.carInterval) {
                return false;
            }
        }
        return true;
    }

}


