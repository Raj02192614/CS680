package umbcs680.observer;

public class DisplayPanelObserver implements Observer<WeatherData> {
    @Override
    public void update(Observable<WeatherData> sender, WeatherData data) {
        System.out.println("Temperature: " + data.getTemperature() + "°F");
        System.out.println("Humidity: " + data.getHumidity() + "%");
        System.out.println("Pressure: " + data.getPressure() + " hPa");
        System.out.println("Wind Speed: " + data.getWindSpeed() + " mph");
        System.out.println("Temperature Trend: " + data.getTempTrend());

        if (data.isTempAlert()) {
            System.out.println("Alert: High Temperature!");
        }
        if (data.isHumidityAlert()) {
            System.out.println("Alert: High Humidity!");
        }
    }
}
