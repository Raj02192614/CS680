package umbcs680.weather;

public class WeatherData {
    private double temperature;
    private double humidity;
    private double pressure;
    private double windSpeed;
    private String tempTrend = "stable";

    public static final double TEMP_THRESHOLD = 100.0;
    public static final double HUMIDITY_THRESHOLD = 85.0;

    private boolean tempAlert;
    private boolean humidityAlert;

    public WeatherData(double temperature, double humidity, double pressure, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        checkAlerts();
    }

    public void set(double newTemp, double newHumidity, double newPressure, double newWindSpeed) {
        if (newTemp > this.temperature) tempTrend = "increasing";
        else if (newTemp < this.temperature) tempTrend = "decreasing";
        else tempTrend = "stable";

        this.temperature = newTemp;
        this.humidity = newHumidity;
        this.pressure = newPressure;
        this.windSpeed = newWindSpeed;
        checkAlerts();
    }

    private void checkAlerts() {
        tempAlert = temperature >= TEMP_THRESHOLD;
        humidityAlert = humidity >= HUMIDITY_THRESHOLD;
    }

    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public double getPressure() { return pressure; }
    public double getWindSpeed() { return windSpeed; }
    public String getTempTrend() { return tempTrend; }
    public boolean isTempAlert() { return tempAlert; }
    public boolean isHumidityAlert() { return humidityAlert; }

    @Override
    public String toString() {
        return String.format("WeatherData [Temperature=%.2f°F (%s), Humidity=%.2f%%, Pressure=%.2f hPa, WindSpeed=%.2f mph]",
                temperature, tempTrend, humidity, pressure, windSpeed);
    }
}
