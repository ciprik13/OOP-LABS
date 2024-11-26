package oop.practice.lab2.Task3;

import oop.practice.lab2.Task3.Coffee.Intensity;
import oop.practice.lab2.Task3.Coffee.SyrupType;

public class Main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Coffee.Intensity.STRONG, 150);
        System.out.println("\n== Cappuccino Details ==");
        cappuccino.makeCappuccino();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.LIGHT, 200, 50);
        System.out.println("\n== Pumpkin Spice Latte Details ==");
        pumpkinSpiceLatte.makePumpkinSpiceLatte();

        Americano americano = new Americano(Intensity.NORMAL, 250);
        System.out.println("\n== Americano Details ==");
        americano.makeAmericano();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.VANILLA);
        System.out.println("\n== Syrup Cappuccino Details ==");
        syrupCappuccino.makeSyrupCappuccino();
    }
}
