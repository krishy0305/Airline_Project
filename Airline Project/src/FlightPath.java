import java.util.*;

public class FlightPath {
    List<String> cities;
    int totalCost;
    int totalTime;

    public FlightPath(List<String> cities, int totalCost, int totalTime) {
        this.cities = new ArrayList<>(cities);
        this.totalCost = totalCost;
        this.totalTime = totalTime;
    }
}
