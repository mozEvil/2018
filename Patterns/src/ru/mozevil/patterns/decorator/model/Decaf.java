package ru.mozevil.patterns.decorator.model;

/**
 * Created by Женя high 13.08.2017.
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
