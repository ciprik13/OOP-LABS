package oop.practice.lab2.Task4;
import java.util.List;

    public class Barista {
        public void makeOrder(List<String> orders){
            for (String order : orders){
                Coffee coffee = takeOrder(order);
                if (coffee != null) {
                    System.out.println("\n===");
                    switch (order.toLowerCase()) {
                        case "coffee":
                            ((Coffee) coffee).makeCoffee();
                            break;
                        case "cappuccino":
                            ((Cappuccino) coffee).makeCappuccino();
                            break;
                        case "americano":
                            ((Americano) coffee).makeAmericano();
                            break;
                        case "pumpkin spice latte":
                            ((PumpkinSpiceLatte) coffee).makePumpkinSpiceLatte();
                            break;
                        case "syrup cappuccino":
                            ((SyrupCappuccino) coffee).makeSyrupCappuccino();
                            break;
                        default:
                            System.out.println("Unknown coffee type: " + order);
                            break;
                    }
                } else {
                    System.out.println("\nSorry, we don't serve " + order + ".");
                }
        }
    }

    private Coffee takeOrder(String order){
        switch (order.toLowerCase()){
            case "coffee":
                return new Coffee(Coffee.Intensity.STRONG);
            case "cappuccino":
                return new Cappuccino(Coffee.Intensity.NORMAL, 25);
            case "americano":
                return new Americano(Coffee.Intensity.STRONG, 50);
            case "pumpkin spice latte":
                return new PumpkinSpiceLatte(Coffee.Intensity.LIGHT, 100, 25);
            case "syrup cappuccino":
                return new SyrupCappuccino(Coffee.Intensity.STRONG, 75, Coffee.SyrupType.POPCORN);
            default:
                return null;
        }
    }
}
