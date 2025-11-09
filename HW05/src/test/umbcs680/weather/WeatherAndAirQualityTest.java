package umbcs680.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeatherAndAirQualityTest {
    private WeatherObservable weatherObservable;
    private AirQualityObservable airQualityObservable;

    private DisplayPanelObserver displayPanel;
    private MobileAppObserver mobileApp;
    private EnvironmentalAgencyObserver environmentalAgency;
    private SmartHomeSystemObserver smartHome;

    @BeforeEach
    void setup() {

        weatherObservable = new WeatherObservable();
        airQualityObservable = new AirQualityObservable();


        displayPanel = new DisplayPanelObserver(); // Shared Observer
        mobileApp = new MobileAppObserver();
        environmentalAgency = new EnvironmentalAgencyObserver();
        smartHome = new SmartHomeSystemObserver();
    }


    @Test
    void testAddObserverWeather() {
        weatherObservable.addObserver(displayPanel);
        weatherObservable.addObserver(mobileApp);

        assertEquals(2, weatherObservable.countObservers(), "WeatherObservable should have 2 observers.");
    }


    @Test
    void testRemoveObserverWeather() {
        weatherObservable.addObserver(displayPanel);
        weatherObservable.addObserver(mobileApp);
        weatherObservable.removeObserver(displayPanel);

        assertEquals(1, weatherObservable.countObservers(), "WeatherObservable should have 1 observer after removal.");
    }
    @Test
    void testClearObservers(){
        weatherObservable.addObserver(displayPanel);
        weatherObservable.addObserver(mobileApp);
        weatherObservable.clearObservers();
        assertEquals(0,weatherObservable.countObservers(),"WeatherObservable should have 0 observers.");
    }


    @Test
    void testNotifyObserversWeather() {
        weatherObservable.addObserver(displayPanel);
        WeatherData weatherEvent = new WeatherData(105, 90, 1012, 15); // High temp & humidity alert

        weatherObservable.notifyObservers(weatherEvent);

        assertTrue(weatherEvent.isTempAlert(), "Temperature should trigger an alert.");
        assertTrue(weatherEvent.isHumidityAlert(), "Humidity should trigger an alert.");
    }


    @Test
    void testAddObserverAirQuality() {
        airQualityObservable.addObserver(environmentalAgency);
        airQualityObservable.addObserver(smartHome);

        assertEquals(2, airQualityObservable.countObservers(), "AirQualityObservable should have 2 observers.");
    }


    @Test
    void testRemoveObserverAirQuality() {
        airQualityObservable.addObserver(environmentalAgency);
        airQualityObservable.addObserver(smartHome);
        airQualityObservable.removeObserver(environmentalAgency);

        assertEquals(1, airQualityObservable.countObservers(), "AirQualityObservable should have 1 observer after removal.");
    }


    @Test
    void testNotifyObserversAirQuality() {
        airQualityObservable.addObserver(environmentalAgency);
        AirQualityData airEvent = new AirQualityData(180, 600, 180); // High pollution & CO2 alert

        airQualityObservable.notifyObservers(airEvent);

        assertTrue(airEvent.isPollutionAlert(), "Pollution level should trigger an alert.");
        assertTrue(airEvent.getCo2Level() > 500, "CO2 level should trigger an alert.");
    }
}
