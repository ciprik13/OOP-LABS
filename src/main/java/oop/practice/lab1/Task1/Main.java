package oop.practice.lab1.Task1;

public class Main {
    public static void main(String[] args) {

        Display display1 = new Display(1920, 1080, 157, "Monitor 1");
        Display display2 = new Display(2560, 1440, 210, "Monitor 2");
        Display display3 = new Display(3840, 2160, 141, "Monitor 3");

        display1.compareWithMonitor(display2);
        display2.compareWithMonitor(display3);
        display1.compareWithMonitor(display3);
    }
}
