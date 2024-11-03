package oop.practice.lab2.Task3;

import oop.practice.lab2.Task3.Coffee;
import oop.practice.lab2.Task3.Cappuccino;
import oop.practice.lab2.Task3.Coffee.Intensity;
import oop.practice.lab2.Task3.Coffee.SyrupType;

public class Main {
    public static void main(String[] args) {
        // Prepare Cappuccino
        Cappuccino cappuccino = new Cappuccino(Coffee.Intensity.STRONG, 150);
        System.out.println("\n== Cappuccino Details ==");
//        cappuccino.printCoffeeDetails();
        cappuccino.makeCappuccino();

        // Prepare Pumpkin Spice Latte
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.LIGHT, 200, 50);
        System.out.println("\n== Pumpkin Spice Latte Details ==");
//        pumpkinSpiceLatte.printCoffeeDetails();
        pumpkinSpiceLatte.makePumpkinSpiceLatte();

        // Prepare Americano
        Americano americano = new Americano(Intensity.NORMAL, 250);
        System.out.println("\n== Americano Details ==");
//        americano.printCoffeeDetails();
        americano.makeAmericano();

        // Prepare Syrup Cappuccino
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.VANILLA);
        System.out.println("\n== Syrup Cappuccino Details ==");
//        syrupCappuccino.printCoffeeDetails();
        syrupCappuccino.makeSyrupCappuccino();
    }
}
