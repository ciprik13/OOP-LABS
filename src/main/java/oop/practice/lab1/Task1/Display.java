package oop.practice.lab1.Task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    public String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // Compare size (area: width * height)
    public String compareSize(Display m) {
        int area1 = this.width * this.height;
        int area2 = m.width * m.height;

        String result;
        if (area1 > area2) {
            result = this.model + " is bigger than " + m.model;
        } else if (area1 < area2) {
            result = m.model + " is bigger than " + this.model;
        } else {
            result = this.model + " and " + m.model + " have the same size.";
        }
        return result;
    }

    // Compare sharpness (ppi)
    public String compareSharpness(Display m) {
        String result;
        if (this.ppi > m.ppi) {
            result = this.model + " is sharper than " + m.model;
        } else if (this.ppi < m.ppi) {
            result = m.model + " is sharper than " + this.model;
        } else {
            result = this.model + " and " + m.model + " have the same sharpness.";
        }
        return result;
    }

    // Compare size and sharpness
    public void compareWithMonitor(Display m) {
        String sizeComparison = compareSize(m);
        String sharpnessComparison = compareSharpness(m);

        System.out.println("Comparison between " + this.model + " and " + m.model + ":");
        System.out.println(sizeComparison);
        System.out.println(sharpnessComparison);
    }
}
