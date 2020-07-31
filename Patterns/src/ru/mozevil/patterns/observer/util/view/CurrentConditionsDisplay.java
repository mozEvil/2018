package ru.mozevil.patterns.observer.util.view;


import ru.mozevil.patterns.observer.util.model.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Женя high 12.08.2017.
 */
public class CurrentConditionsDisplay implements DisplayElement, Observer {

    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: temperature - " + temperature + "F, humidity - " + humidity + "%");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
