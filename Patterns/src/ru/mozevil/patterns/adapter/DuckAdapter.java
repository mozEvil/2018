package ru.mozevil.patterns.adapter;

/**
 * Created by Женя on 18.08.2017.
 */
public class DuckAdapter implements Turkey {

    private Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
