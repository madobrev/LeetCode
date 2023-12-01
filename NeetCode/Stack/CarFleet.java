package Stack;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        Map<Double, Double> carMap = new TreeMap<>(Collections.reverseOrder());
        int amountOfCarFleets = 0;
        double slowestTimeToReachEnd = -1;

        for (int i = 0; i < position.length; i++) {
            double carPosition = position[i];
            double carSpeed = speed[i];
            double timeToReachEnd = (target - carPosition) / carSpeed;

            carMap.put(carPosition, timeToReachEnd);
        }

        for (double timeToEnd : carMap.values()) {
            if (timeToEnd > slowestTimeToReachEnd) {
                slowestTimeToReachEnd = timeToEnd;
                amountOfCarFleets++;
            }
        }

        return amountOfCarFleets;
    }

    public static void main(String[] args) {

    }
}
