package ru.mozevil.patterns.observer.self;

import ru.mozevil.patterns.observer.self.model.WeatherData;
import ru.mozevil.patterns.observer.self.view.CurrentConditionsDisplay;

/**
 * Created by Женя high 12.08.2017.
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 66, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 91, 30);
    }
}
