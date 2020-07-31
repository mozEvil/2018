package ru.mozevil.patterns.strategy.behaviors.quack;

/**
 * Created by Женя high 11.08.2017.
 */
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
