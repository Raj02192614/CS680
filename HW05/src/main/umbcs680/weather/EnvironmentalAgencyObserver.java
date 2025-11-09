package umbcs680.weather;

public class EnvironmentalAgencyObserver implements AirQualityObserver {
    @Override
    public void updateAirQuality(AirQualityData event) {
        System.out.println("[Environmental Agency] -> Air Quality Update Received:");
        System.out.println(event.toString());

        if (event.isPollutionAlert()) {
            System.out.println("[Environmental Agency] -> High Pollution Alert! Advising the public to limit outdoor activities.");
        }

        if (event.getCo2Level() > 500) {
            System.out.println("[Environmental Agency] -> High CO2 levels detected. Investigating industrial emissions.");
        }
    }
}
