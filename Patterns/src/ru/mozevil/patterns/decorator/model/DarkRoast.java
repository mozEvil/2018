package ru.mozevil.patterns.decorator.model;

/**
 * Created by Женя high 13.08.2017.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
