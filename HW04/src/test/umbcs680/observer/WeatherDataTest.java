package umbcs680.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataTest {
    private WeatherObservable observable;
    private WeatherData weatherData;
    private WeatherDataStation station;
    private DisplayPanelObserver display;
    private MobileAppObserver app;

    @BeforeEach
    public void setup() {
        observable = new WeatherObservable();
        station = new WeatherDataStation("BostonStation");
        display = new DisplayPanelObserver();
        app = new MobileAppObserver();
    }

    @Test
    public void testAddObserver() {
        observable.addObserver(display);
        observable.addObserver(app);
        observable.addObserver(station);
        assertEquals(3,observable.countObservers());
    }
    @Test
    public void testRemoveObserver() {
        observable.addObserver(display);
        observable.addObserver(app);
        observable.addObserver(station);

        assertEquals(3, observable.countObservers());
        observable.removeObserver(app);
        observable.removeObserver(station);
        assertEquals(1, observable.countObservers());
    }

    @Test
    public void testClearObservers() {
        observable.addObserver(display);
        observable.addObserver(app);
        observable.addObserver(station);

        assertEquals(3, observable.countObservers());

        observable.clearObservers();

        assertEquals(0, observable.countObservers());
    }
    @Test
    public void testObserverReceivesHighHumidityAlert() {

        observable.addObserver(station);
        observable.addObserver(display);
        observable.addObserver(app);


        WeatherData externalData = new WeatherData(80.0, 90.0, 1008.0, 10.0);
        observable.updateWeatherData(externalData);


        WeatherData stationData = station.getCurrentData();


        assertEquals(80.0, stationData.getTemperature(), 0.01);
        assertEquals(90.0, stationData.getHumidity(), 0.01);
        assertEquals(1008.0, stationData.getPressure(), 0.01);
        assertEquals(10.0, stationData.getWindSpeed(), 0.01);
        assertTrue(stationData.isHumidityAlert());
        assertFalse(stationData.isTempAlert());                 
    }

}
