package ru.mozevil.patterns.observer.my.impl;

import java.util.Vector;

/**
 * Created by Женя high 12.08.2017.
 */
public class MyObservable implements Observable {

    private Vector<Observer> observers;

    public MyObservable() {
        observers = new Vector<>();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!observers.contains(o)) {
            observers.addElement(o);
        }
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        observers.removeElement(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        Object[] observersLocal;

        synchronized (this) {
            observersLocal = observers.toArray();
        }

        for (Object o : observersLocal) {
            ((Observer)o).update(this, arg);
        }
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public synchronized void clearObservers() {
        observers.removeAllElements();
    }
}
