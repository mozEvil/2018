package ru.mozevil.patterns.strategy.behaviors.quack;

/**
 * Created by Женя high 11.08.2017.
 */
public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
