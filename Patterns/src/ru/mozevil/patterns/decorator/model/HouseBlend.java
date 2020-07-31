package ru.mozevil.patterns.decorator.model;

/**
 * Created by Женя high 13.08.2017.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
