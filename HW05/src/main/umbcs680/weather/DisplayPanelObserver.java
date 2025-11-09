package umbcs680.weather;

public class DisplayPanelObserver implements WeatherObserver, AirQualityObserver {
    @Override
    public void updateWeather(WeatherData data) {
        System.out.println("[Display Panel] Weather Update:");
        System.out.println("Temperature: " + data.getTemperature() + "°F");
        System.out.println("Humidity: " + data.getHumidity() + "%");
        System.out.println("Pressure: " + data.getPressure() + " hPa");
        System.out.println("Wind Speed: " + data.getWindSpeed() + " mph");
        System.out.println("Temperature Trend: " + data.getTempTrend());

        if (data.isTempAlert()) {
            System.out.println("[Display Panel]-> High Temperature Alert!");
        }
        if (data.isHumidityAlert()) {
            System.out.println("[Display Panel]-> High Humidity Alert!");
        }
    }

    @Override
    public void updateAirQuality(AirQualityData event) {
        System.out.println("[Display Panel] Air Quality Update:");
        System.out.println("AQI: " + event.getAirQualityIndex());
        System.out.println("CO2 Level: " + event.getCo2Level() + " ppm");
        System.out.println("Pollution Level: " + event.getPollutionLevel() + " µg/m3");

        if (event.isPollutionAlert()) {
            System.out.println("[Display Panel] -> High Pollution Alert! Avoid outdoor exposure.");
        }
    }
}
