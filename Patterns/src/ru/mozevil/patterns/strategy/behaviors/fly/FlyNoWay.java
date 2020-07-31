package ru.mozevil.patterns.strategy.behaviors.fly;

/**
 * Created by Женя high 11.08.2017.
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
