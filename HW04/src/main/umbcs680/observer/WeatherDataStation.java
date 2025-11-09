package umbcs680.observer;

public class WeatherDataStation implements Observer<WeatherData> {
    private String stationName;
    private double calibrationOffset = 0.0;
    private double lastMeasuredTemp = 0.0;
    private WeatherData currentData;

    public WeatherDataStation(String name) {
        this.stationName = name;
    }

    @Override
    public void update(Observable<WeatherData> source, WeatherData externalData) {
        double externalTemp = externalData.getTemperature();
        calibrationOffset = (externalTemp - lastMeasuredTemp) * 0.5; // Simple calibration
        System.out.println("[" + stationName + "] Calibrated with offset: " + calibrationOffset);


        currentData = externalData;
    }

    public WeatherData measureWeather(double temp, double humidity, double pressure, double windSpeed) {
        double adjustedTemp = temp + calibrationOffset;


        WeatherData data = new WeatherData(adjustedTemp, humidity, pressure, windSpeed);


        lastMeasuredTemp = adjustedTemp;


        currentData = data;


        System.out.println("[" + stationName + "] Weather Data: " + data);


        return data;
    }

    // ✅ FIX: Added this method to allow retrieval of the latest measured data (used in test case)
    public WeatherData getCurrentData() {
        return currentData;
    }
}
