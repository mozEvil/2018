package ru.mozevil.patterns.singlelton;

/**
 * Created by Женя high 17.08.2017.
 */
public class LazySyncSingleton {

    private static LazySyncSingleton ourInstance;

    private LazySyncSingleton() {}

    public static synchronized LazySyncSingleton getInstance() {
        if (ourInstance == null){
            ourInstance = new LazySyncSingleton();
        }
        return ourInstance;
    }

}
