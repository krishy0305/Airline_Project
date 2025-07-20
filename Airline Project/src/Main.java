import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> flightDataList = new ArrayList<>();
            File flightFile = new File("flightData.txt");
            Scanner flightScanner = new Scanner(flightFile);
            while(flightScanner.hasNextLine()) {
                flightDataList.add(flightScanner.nextLine());
            }
            flightScanner.close();
            String[] flightData = flightDataList.toArray(new String[0]);

            List<String> requestsList = new ArrayList<>();
            File requestFile = new File("reqFlights.txt");
            Scanner requestScanner = new Scanner(requestFile);
            while(requestScanner.hasNextLine()) {
                requestsList.add(requestScanner.nextLine());
            }
            requestScanner.close();
            String[] requests = requestsList.toArray(new String[0]);

            FlightPlanner planner = new FlightPlanner();
            planner.readFlightData(flightData);
            List<String> output = planner.processFlightRequests(requests);

            for(String outputLine: output) {
                System.out.println(outputLine);
            }
        }

        catch(FileNotFoundException e) {
            System.out.println("Error reading input files: " + e.getMessage());
        }
    }
}