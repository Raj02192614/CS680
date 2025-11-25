Weather Monitoring System using Observer Design Pattern

Description:
For this project, I designed a Weather Monitoring System that updates different components like display panels, mobile apps, and weather stations whenever new weather data is available. The system simulates real-time weather updates, including temperature, humidity, pressure, wind speed, and trends, with alerts for extreme conditions.

Implementation of Observer Design Pattern:

Observable Class (WeatherObservable):
Manages a list of observers and notifies them when weather data changes using notifyObservers().

Observer Interface (Observer<T>):
Defines the update() method for receiving updates.

Concrete Observers:

DisplayPanelObserver: Shows full weather details and alerts.
MobileAppObserver: Focuses on sending temperature and humidity alerts.
WeatherDataStation: Simulates a real station that calibrates and logs incoming data.
WeatherData (Data Class):
Stores weather information and computes temperature trends and alerts (e.g., high temp or humidity).

State Change and Notification Flow:
When new weather data is received, WeatherObservable calls notifyObservers(), and each observer reacts accordingly (e.g., showing alerts if conditions are extreme).

Testing:
Included unit tests (WeatherDataTest.java) check if observers are correctly added, removed, notified, and if alerts are triggered as expected for extreme weather.


This system effectively demonstrates the Observer design pattern by decoupling weather data updates from the components that react to them, enabling dynamic and independent updates across multiple observers.

