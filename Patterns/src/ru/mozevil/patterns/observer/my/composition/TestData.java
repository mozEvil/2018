package ru.mozevil.patterns.observer.my.composition;

/**
 * Created by Женя high 12.08.2017.
 */
public class TestData {

    private int x;
    private int y;

    private Observable observable;

    public TestData() {
        setObservable(new SynchronizedObservable());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    public void notifyObservers() {
        if (observable != null) {
            observable.notifyObservers(this);
        }
    }
}
