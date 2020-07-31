package ru.mozevil.patterns.adapter;

/**
 * Created by Женя on 18.08.2017.
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
