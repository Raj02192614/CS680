package umbcs680.weather;

import java.util.LinkedList;
import java.util.List;

public class WeatherObservable {
    private LinkedList<WeatherObserver> observers = new LinkedList<>();

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }
    public void clearObservers() {
        observers.clear();
    }
    public List<WeatherObserver> getObservers(){
        return observers;
    }

    public int countObservers() {
        return observers.size();
    }

    public void notifyObservers(WeatherData event) {
        for (WeatherObserver observer : observers) {
            observer.updateWeather(event);
        }
    }
}
