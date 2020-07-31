package ru.mozevil.patterns.observer.self.view;

import ru.mozevil.patterns.observer.self.model.Observable;
import ru.mozevil.patterns.observer.self.model.Observer;
import ru.mozevil.patterns.observer.self.model.WeatherData;

/**
 * Created by Женя high 12.08.2017.
 */
public class CurrentConditionsDisplay implements DisplayElement, Observer {

    private float temperature;
    private float humidity;
    private Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: temperature - " + temperature + "F, humidity - " + humidity + "%");
    }

    @Override
    public void update(Observable o) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
