import java.util.*;

public class FlightPlanner {
    private Graph graph;

    public FlightPlanner() {
        graph = new Graph();
    }

    public void readFlightData(String[] flightData) {
        int numFlights = Integer.parseInt(flightData[0]);
        for(int i = 1; i <= numFlights; i++) {
            String[] parts = flightData[i].split("\\|");
            String origin = parts[0];
            String destination = parts[1];
            int cost = Integer.parseInt(parts[2]);
            int time = Integer.parseInt(parts[3]);
            graph.addFlight(origin, destination, cost, time);
        }
    }

    public List<String> processFlightRequests(String[] requests) {
        List<String> output = new ArrayList<>();
        int numRequests = Integer.parseInt(requests[0]);
        for(int i = 1; i <= numRequests; i++) {
            String[] parts = requests[i].split("\\|");
            String origin = parts[0];
            String destination = parts[1];
            char sortBy = parts[2].charAt(0);

            output.add(String.format("Flight %d: %s, %s (%s)", i, origin, destination, sortBy == 'T' ? "Time" : "Cost"));
            List<FlightPath> paths = graph.findAllPaths(origin, destination, sortBy);

            if(paths.isEmpty()) {
                output.add("No flight plan available.");
            }
            else {
                for(int j = 0; j < paths.size(); j++) {
                    FlightPath path = paths.get(j);
                    String pathStr = String.join(" -> ", path.cities);
                    output.add(String.format("Path %d: %s. Time: %d Cost: %d.00", j+1, pathStr, path.totalTime, path.totalCost));
                }
            }

            if(i < numRequests)
                output.add("");
        }
        return output;
    }
}
