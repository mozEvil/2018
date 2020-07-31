package ru.mozevil.patterns.strategy.behaviors.fly;

/**
 * Created by Женя high 11.08.2017.
 */
public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
