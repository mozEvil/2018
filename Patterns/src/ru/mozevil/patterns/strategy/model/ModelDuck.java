package ru.mozevil.patterns.strategy.model;

import ru.mozevil.patterns.strategy.behaviors.fly.FlyNoWay;
import ru.mozevil.patterns.strategy.behaviors.quack.Quack;

/**
 * Created by Женя high 11.08.2017.
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a pizza duck");
    }
}
