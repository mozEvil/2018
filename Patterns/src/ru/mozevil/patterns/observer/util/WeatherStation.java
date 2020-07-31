package ru.mozevil.patterns.observer.util;


import ru.mozevil.patterns.observer.util.model.WeatherData;
import ru.mozevil.patterns.observer.util.view.CurrentConditionsDisplay;

import java.util.Observable;

/**
 * Created by Женя high 12.08.2017.
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 66, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 31);

        Observable obs = new Observable();
        obs.addObserver((o, arg) -> System.out.println("1"));
        obs.addObserver((o, arg) -> System.out.println("2"));


        obs.notifyObservers();
    }
}
