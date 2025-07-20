import java.util.*;

public class Graph {
    private Map<String, List<FlightLeg>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addFlight(String origin, String destination, int cost, int time) {
        adjList.computeIfAbsent(origin, k -> new ArrayList<>()).add(new FlightLeg(destination, cost, time));
        adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new FlightLeg(origin, cost, time));
    }

    public List<FlightPath> findAllPaths(String start, String end, char sortBy) {
        List<FlightPath> paths = new ArrayList<>();
        Stack<List<String>> stack = new Stack<>();
        Stack<Integer> costStack = new Stack<>();
        Stack<Integer> timeStack = new Stack<>();
        Set<String> visited = new HashSet<>();

        List<String> initialPath = new ArrayList<>();
        initialPath.add(start);
        stack.push(initialPath);
        costStack.push(0);
        timeStack.push(0);
        visited.add(start);

        while(!stack.isEmpty()) {
            List<String> currentPath = stack.pop();
            int currentCost = costStack.pop();
            int currentTime = timeStack.pop();
            String currentCity = currentPath.get(currentPath.size() - 1);

            visited.clear();
            visited.addAll(currentPath);

            if(currentCity.equals(end)) {
                paths.add(new FlightPath(currentPath, currentCost, currentTime));
                continue;
            }

            for(FlightLeg leg : adjList.getOrDefault(currentCity, new ArrayList<>())) {
                if(!visited.contains(leg.destination)) {
                    List<String> newPath = new ArrayList<>(currentPath);
                    newPath.add(leg.destination);
                    stack.push(newPath);
                    costStack.push(currentCost + leg.cost);
                    timeStack.push(currentTime + leg.time);
                }
            }
        }

        paths.sort((p1, p2) -> sortBy == 'T' ? p1.totalTime - p2.totalTime : p1.totalCost - p2.totalCost);
        return paths.size() > 3 ? paths.subList(0, 3) : paths;
    }
}
