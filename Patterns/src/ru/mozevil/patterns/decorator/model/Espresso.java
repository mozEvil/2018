package ru.mozevil.patterns.decorator.model;

/**
 * Created by Женя high 13.08.2017.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
