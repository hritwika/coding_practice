import java.util.*;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Step 1: Pair each car's position with time to reach target
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // position
            cars[i][1] = (double)(target - position[i]) / speed[i]; // time
        }

        // Step 2: Sort cars by starting position (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Step 3: Stack to keep track of fleets
        int fleets = 0;
        double currentTime = 0;

        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            // If this car cannot catch up with the fleet ahead, it's a new fleet
            if (time > currentTime) {
                fleets++;
                currentTime = time;
            }
            // else: the car joins the current fleet (do nothing)
        }

        return fleets;
    }
}
