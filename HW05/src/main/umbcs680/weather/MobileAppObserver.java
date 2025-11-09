package umbcs680.weather;

public class MobileAppObserver implements WeatherObserver {
    @Override
    public void updateWeather(WeatherData data) {
        if (data.isTempAlert() || data.isHumidityAlert()) {
            System.out.println("Mobile App Alert: Check weather conditions!");
            if (data.isTempAlert()) {
                System.out.println("High Temperature: " + data.getTemperature() + "°F");
            }
            if (data.isHumidityAlert()) {
                System.out.println("High Humidity: " + data.getHumidity() + "%");
            }
        }
    }
}
