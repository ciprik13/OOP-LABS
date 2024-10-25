package oop.practice.lab1.Task3;

import oop.practice.lab1.Task1.Display;
import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    public void assist() {
        System.out.println("Assistant " + assistantName + " is assisting with display comparisons:");
        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            Display currentDisplay = assignedDisplays.get(i);
            Display nextDisplay = assignedDisplays.get(i + 1);

            System.out.println(currentDisplay.compareSize(nextDisplay));
            System.out.println(currentDisplay.compareSharpness(nextDisplay));
        }
    }

    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println(d.model + " has been removed from the list of assigned displays.");
            return d;
        } else {
            System.out.println("Display not found in the list.");
            return null;
        }
    }
}
