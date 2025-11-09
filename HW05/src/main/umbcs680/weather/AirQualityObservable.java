package umbcs680.weather;

import java.util.LinkedList;
import java.util.List;

public class AirQualityObservable {
    private LinkedList<AirQualityObserver> observers = new LinkedList<>();

    public void addObserver(AirQualityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AirQualityObserver observer) {
        observers.remove(observer);
    }

    public void clearObservers() {
        observers.clear();
    }
    public List<AirQualityObserver> getObservers(){
        return observers;
    }

    public int countObservers() {
        return observers.size();
    }

    public void notifyObservers(AirQualityData event) {
        for (AirQualityObserver observer : observers) {
            observer.updateAirQuality(event);
        }
    }
}
