package ru.mozevil.patterns.observer.my.impl;

/**
 * Created by Женя high 12.08.2017.
 */
public interface Observable {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(Object arg);

    void notifyObservers();

    void clearObservers();
}
