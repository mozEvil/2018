package ru.mozevil.patterns.singlelton;

/**
 * Created by Женя high 17.08.2017.
 */
public class LazySingleton {

    private static LazySingleton ourInstance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (ourInstance == null){
            ourInstance = new LazySingleton();
        }
        return ourInstance;
    }

}
