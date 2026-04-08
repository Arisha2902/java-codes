package WeatherSystem;

public class WeatherStation {
    
    public void analyze(WeatherType type, Double humidity) throws IncompleteDataException {
        if (humidity == null) {
            throw new IncompleteDataException("Humidity sensor failure!");
        }

        System.out.print("Current Condition: " + type);
        
        if (type == WeatherType.STORMY && humidity > 80.0) {
            System.out.println(" - ALERT: High risk of flash floods.");
        } else {
            System.out.println(" - Conditions stable.");
        }
    }

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        try {
            station.analyze(WeatherType.STORMY, 85.5);
            station.analyze(WeatherType.SUNNY, null); // This will trigger the catch block
        } catch (IncompleteDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}