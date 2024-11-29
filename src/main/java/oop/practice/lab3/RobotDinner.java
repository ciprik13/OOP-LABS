package oop.practice.lab3;

public class RobotDinner implements Dineable {
    private int robotsServed = 0;
    private static int totalRobot = 0;

    @Override
    public void serveDinner(int carId) {
        System.out.println("Serving dinner to robots in car " + carId);
        robotsServed++;
    }

    public static void countRobot(){
        totalRobot++;
    }

    public int getRobotsServed() {
        return robotsServed;
    }
}
