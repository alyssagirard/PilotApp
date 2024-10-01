import java.util.ArrayList;

public class FlightDataGenerator {

    public static String[] flightColumnNames = {
        "Date", "Flight Time", "Departure Airport", "Arrival Airport", 
        "Aircraft Type", "Aircraft Registration", "Safety Pilot"
    };

    private ArrayList<ArrayList<String>> flightData = new ArrayList<>();

    public FlightDataGenerator() {
        generateRandomFlightData(5);
    }

    private void generateRandomFlightData(int numRows) {

        for (int i = 0; i < numRows; i++) {
            ArrayList<String> row = new ArrayList<>();
            row.add(generateRandomDate());
            row.add(generateRandomFlightTime());
            row.add(generateRandomAirportCode());
            row.add(generateRandomAirportCode());
            row.add(generateRandomAircraftType());
            row.add(generateRandomAircraftRegistration());
            row.add("Example Name");
            flightData.add(row);
        }
    }

    private String generateRandomDate() {
        int year = 2020 + (int)(Math.random() * 5);
        int month = 1 + (int)(Math.random() * 12);
        int day = 1 + (int)(Math.random() * 28);
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    private String generateRandomFlightTime() {
        int hours = (int)(Math.random() * 5);
        int minutes = (int)(Math.random() * 60);
        return String.format("%02d:%02d", hours, minutes);
    }

    private String generateRandomAirportCode() {
        String[] airportCodes = {"JFK", "LAX", "ORD", "ATL", "DFW", "SFO", "MIA", "SEA", "DEN", "LAS"};
        return airportCodes[(int)(Math.random() * airportCodes.length)];
    }

    private String generateRandomAircraftType() {
        String[] aircraftTypes = {"Cessna 172", "Boeing 737", "Airbus A320", "Piper PA-28", "Cirrus SR22"};
        return aircraftTypes[(int)(Math.random() * aircraftTypes.length)];
    }

    private String generateRandomAircraftRegistration() {
        return "N" + (1000 + (int)(Math.random() * 9000));
    }

    public ArrayList<ArrayList<String>> getFlightData() {
        return flightData;
    }

    public static void main(String[] args) {
        FlightDataGenerator generator = new FlightDataGenerator();
        ArrayList<ArrayList<String>> flightData = generator.getFlightData();

        for (ArrayList<String> row : flightData) {
            System.out.println(row);
        }
    }
}
