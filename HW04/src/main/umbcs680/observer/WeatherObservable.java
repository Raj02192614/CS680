package umbcs680.observer;

public class WeatherObservable extends Observable<WeatherData> {
    public void updateWeatherData(WeatherData data) {
        this.notifyObservers(data);
    }
}
