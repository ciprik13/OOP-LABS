package oop.practice.lab3;

public class Main {
    public static void main(String[] args) {
        String queueDirectory = "src/main/java/oop/practice/lab3/queue";
        Scheduler scheduler = new Scheduler(queueDirectory);

        scheduler.scheduleChecking(2);
        scheduler.scheduleServing(5);

    }
}
