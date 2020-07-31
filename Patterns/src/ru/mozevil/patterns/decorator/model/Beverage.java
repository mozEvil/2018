package ru.mozevil.patterns.decorator.model;

/**
 * Created by Женя high 13.08.2017.
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
