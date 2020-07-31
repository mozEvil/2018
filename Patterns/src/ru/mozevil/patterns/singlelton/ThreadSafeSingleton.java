package ru.mozevil.patterns.singlelton;

/**
 * Created by Женя high 17.08.2017.
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton ourInstance = new ThreadSafeSingleton();

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        return ourInstance;
    }

}
