package oop.practice.lab1.Task3;

import oop.practice.lab1.Task1.Display;

public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("Tech Assistant");

        Display display1 = new Display(1920, 1080, 157, "Monitor 1");
        Display display2 = new Display(2560, 1440, 210, "Monitor 2");
        Display display3 = new Display(3840, 2160, 141, "Monitor 3");

        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        assistant.assist();
        assistant.buyDisplay(display2);

        assistant.assist();
        assistant.buyDisplay(display2);

        assistant.assist();
        assistant.buyDisplay(display1);

        assistant.assist();
        assistant.buyDisplay(display3);
    }
}
