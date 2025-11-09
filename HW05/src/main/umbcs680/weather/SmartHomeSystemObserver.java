package umbcs680.weather;

public class SmartHomeSystemObserver implements AirQualityObserver {
    @Override
    public void updateAirQuality(AirQualityData event) {
        System.out.println("[Smart Home System] -> Checking Indoor Air Quality...");

        if (event.isPollutionAlert()) {
            System.out.println("[Smart Home System] -> High pollution detected outside! Keeping windows closed.");
        } else {
            System.out.println("[Smart Home System] -> Good air quality detected. Opening windows for ventilation.");
        }

        if (event.getCo2Level() > 450) {
            System.out.println("[Smart Home System] -> CO2 levels rising indoors. Activating air filtration system.");
        }
    }
}
