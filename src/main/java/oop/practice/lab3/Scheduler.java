package oop.practice.lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final String queueDirectory;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ScheduledExecutorService checkingExecutor = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledExecutorService servingExecutor = Executors.newSingleThreadScheduledExecutor();

    private final CarStation gasPeopleStation;
    private final CarStation gasRobotStation;
    private final CarStation electricPeopleStation;
    private final CarStation electricRobotStation;

    private final Semaphore semaphore;

    private long lastProcessedTime = System.currentTimeMillis(); // Track last processed time
    private final long TIMEOUT = 10000; // 5 seconds timeout (in milliseconds)

    public Scheduler(String queueDirectory) {
        this.queueDirectory = queueDirectory;

        // Initialize CarStations and Semaphore
        this.gasPeopleStation = new CarStation(
                new PeopleDinner(),
                new GasStation(),
                new LinkedQueue<>(30)
        );

        this.gasRobotStation = new CarStation(
                new RobotDinner(),
                new GasStation(),
                new ArrayQueue<>(30)
        );

        this.electricPeopleStation = new CarStation(
                new PeopleDinner(),
                new ElectricStation(),
                new LinkedQueue<>(30)
        );

        this.electricRobotStation = new CarStation(
                new RobotDinner(),
                new ElectricStation(),
                new LinkedQueue<>(30)
        );

        this.semaphore = new Semaphore(
                gasPeopleStation,
                gasRobotStation,
                electricPeopleStation,
                electricRobotStation
        );
    }

    private void pollQueueDirectory() {
        File directory = new File(queueDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid queue directory: " + queueDirectory);
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));
        if (files != null) {
            for (File file : files) {
                try {
                    // Read and process the car from JSON file
                    Car car = objectMapper.readValue(file, Car.class);

                    // Route the car based on its properties
                    semaphore.routeCar(car);

                    // Delete the processed file
                    Files.delete(Paths.get(file.getPath()));

                    lastProcessedTime = System.currentTimeMillis();

                } catch (Exception e) {
                    System.err.println("Error processing file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    public void scheduleChecking(int intervalSeconds) {
        checkingExecutor.scheduleAtFixedRate(this::pollQueueDirectory, 0, intervalSeconds, TimeUnit.SECONDS);
        checkingExecutor.scheduleAtFixedRate(this::checkTimeout, 0, 1, TimeUnit.SECONDS); // Run every 1 second
    }

    public void scheduleServing(int intervalSeconds) {
        servingExecutor.scheduleAtFixedRate(() -> {
            System.out.println("\nServing cars: ");
            semaphore.serveCar();
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }

    private void checkTimeout() {
        if (System.currentTimeMillis() - lastProcessedTime > TIMEOUT) {
            System.out.println("No new files processed in the last 10 seconds. Shutting down...");
            shutdown();
        }
    }


    public void shutdown() {
        try {
            checkingExecutor.shutdown();
            servingExecutor.shutdown();

            if (!checkingExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                checkingExecutor.shutdownNow();
            }
            if (!servingExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                servingExecutor.shutdownNow();
            }

            gasPeopleStation.serveCars();
            gasRobotStation.serveCars();
            electricPeopleStation.serveCars();
            electricRobotStation.serveCars();

            printStats();

        } catch (InterruptedException e) {
            System.err.println("Error during shutdown. Forcing termination...");
            checkingExecutor.shutdownNow();
            servingExecutor.shutdownNow();
        }
    }

    public void printStats() {
        Map<String,Integer> stats = semaphore.getStats();

        String statistic = String.format(
                "{ \"ELECTRIC\": %d, \"GAS\": %d, \"PEOPLE\": %d, \"ROBOTS\": %d, \"DINING\": %d, \"NOT_DINING\": %d, " +
                        "\"CONSUMPTION\": { \"ELECTRIC\": %d, \"GAS\": %d } }",
                stats.get("ELECTRIC cars served"),
                stats.get("GAS cars served"),
                stats.get("PEOPLE are served"),
                stats.get("ROBOTS are served"),
                stats.get("DINING cars"),
                stats.get("NON-DINING cars"),
                ElectricStation.getElectricConsumption(),
                GasStation.getGasConsumption()
        );

        System.out.println();
        System.out.println(statistic);
    }
}
