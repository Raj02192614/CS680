package umbcs680.weather;

public class AirQualityData {
    private final double airQualityIndex;
    private final double co2Level;
    private final double pollutionLevel;
    private boolean pollutionAlert;

    private static final double POLLUTION_THRESHOLD = 150.0;

    public AirQualityData(double airQualityIndex, double co2Level, double pollutionLevel) {
        this.airQualityIndex = airQualityIndex;
        this.co2Level = co2Level;
        this.pollutionLevel = pollutionLevel;
        checkAlert();
    }

    private void checkAlert() {
        pollutionAlert = pollutionLevel > POLLUTION_THRESHOLD;
    }

    public double getAirQualityIndex() { return airQualityIndex; }
    public double getCo2Level() { return co2Level; }
    public double getPollutionLevel() { return pollutionLevel; }
    public boolean isPollutionAlert() { return pollutionAlert; }

    @Override
    public String toString() {
        return String.format("Air Quality Data [AQI=%.2f, CO2 Level=%.2f ppm, Pollution Level=%.2f µg/m3]",
                airQualityIndex, co2Level, pollutionLevel);
    }
}
