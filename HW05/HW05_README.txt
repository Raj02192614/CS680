Integrated Weather and Air Quality Monitoring System (Observer Pattern)

Description:
For this assignment, I extended the Observer design pattern to build a combined system that monitors both weather and air quality conditions. The system includes multiple observers like display panels, mobile apps, environmental agencies, and smart home systems that react to real-time updates in weather and air quality data. Alerts are triggered dynamically when conditions exceed predefined thresholds (e.g., high temperature, high pollution).

 Implemention:

Observable Classes:

WeatherObservable: Notifies registered weather observers when new WeatherData is available.
AirQualityObservable: Notifies air quality observers when new AirQualityData is available.
Observer Interfaces:

WeatherObserver: Reacts to weather data updates.
AirQualityObserver: Reacts to air quality data updates.
Concrete Observers:

DisplayPanelObserver: Displays both weather and air quality updates, including alerts.
MobileAppObserver: Focused on weather alerts like high temperature.
SmartHomeSystemObserver: Adjusts home ventilation based on air quality alerts (e.g., pollution or CO2 levels).
Data Classes with Alerts:

WeatherData: Contains weather information and alerts (high temp).
AirQualityData: Contains AQI, CO2, pollution data with pollution alerts.
Decoupled and Dynamic Updates:
Observers are dynamically registered and notified of relevant updates, enabling modular and extensible design. Shared observers (like DisplayPanel) handle both weather and air quality notifications.

Testing:
Comprehensive unit tests (WeatherQualityAndTest.java) verify the correct addition, removal, and notification of observers. Tests also validate that alerts are triggered correctly for extreme weather and pollution conditions.


This project effectively demonstrates a dual use of the Observer pattern, supporting two different types of observable events (weather and air quality) and dynamically notifying various observer types in a decoupled and responsive system.