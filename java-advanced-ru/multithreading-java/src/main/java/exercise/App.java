package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> minMax = new HashMap<>();

        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        LOGGER.log(Level.INFO, "INFO: Thread " + maxThread.getName() + " started");
        maxThread.start();

        LOGGER.log(Level.INFO, "INFO: Thread " + minThread.getName() + " started");
        minThread.start();

        try {
            maxThread.join();
            LOGGER.log(Level.INFO, "INFO: Thread " + maxThread.getName() + " finished");

            minThread.join();
            LOGGER.log(Level.INFO, "INFO: Thread " + minThread.getName() + " finished");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        minMax.put("min", minThread.getMin());
        minMax.put("max", maxThread.getMax());

        return minMax;
    }
    // END
}
