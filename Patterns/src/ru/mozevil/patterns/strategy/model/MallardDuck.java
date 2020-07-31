package ru.mozevil.patterns.strategy.model;


import ru.mozevil.patterns.strategy.behaviors.fly.FlyWithWings;
import ru.mozevil.patterns.strategy.behaviors.quack.Quack;

/**
 * Created by Женя high 11.08.2017.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
