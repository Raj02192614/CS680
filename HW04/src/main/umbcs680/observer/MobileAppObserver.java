package umbcs680.observer;

public class MobileAppObserver implements Observer<WeatherData> {
    @Override
    public void update(Observable<WeatherData> sender, WeatherData data) {
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
