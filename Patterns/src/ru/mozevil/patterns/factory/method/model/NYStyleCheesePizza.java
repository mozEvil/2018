package ru.mozevil.patterns.factory.method.model;

/**
 * Created by Женя high 14.08.2017.
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grate Reggiano Cheese");
    }
}
