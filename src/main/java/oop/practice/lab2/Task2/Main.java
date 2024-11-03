package oop.practice.lab2.Task2;

public class Main {
    public static void main(String[] args) {
        // Coffee Object
        Coffee coffee = new Coffee(Coffee.Intensity.NORMAL);
        System.out.println("== Coffee Details ==");
        coffee.printCoffeeDetails();

        // Cappuccino Object
        Cappuccino cappuccino = new Cappuccino(Coffee.Intensity.STRONG, 150);
        System.out.println("\n== Cappuccino Details ==");
        cappuccino.printCoffeeDetails();

        // PumpkinSpiceLatte Object
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Coffee.Intensity.LIGHT, 200, 50);
        System.out.println("\n== Pumpkin Spice Latte Details ==");
        pumpkinSpiceLatte.printCoffeeDetails();

        // Americano Object
        Americano americano = new Americano(Coffee.Intensity.STRONG, 250);
        System.out.println("\n== Americano Details ==");
        americano.printCoffeeDetails();

        // SyrupCappuccino Object
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Coffee.Intensity.NORMAL, 150, Coffee.SyrupType.VANILLA);
        System.out.println("\n== Syrup Cappuccino Details ==");
        syrupCappuccino.printCoffeeDetails();
    }
}
