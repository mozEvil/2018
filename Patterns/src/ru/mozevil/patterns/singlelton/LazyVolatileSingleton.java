package ru.mozevil.patterns.singlelton;

/**
 * Created by Женя high 17.08.2017.
 */
public class LazyVolatileSingleton {

    private volatile static LazyVolatileSingleton ourInstance;

    private LazyVolatileSingleton() {
    }

    public static LazyVolatileSingleton getInstance() {
        if (ourInstance == null) {
            synchronized (LazyVolatileSingleton.class) {
                if (ourInstance == null) {
                    ourInstance = new LazyVolatileSingleton();
                }
            }
        }
        return ourInstance;
    }

}
