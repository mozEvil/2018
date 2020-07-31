package ru.mozevil.patterns.factory.simple;

import ru.mozevil.patterns.factory.simple.model.CheesePizza;
import ru.mozevil.patterns.factory.simple.model.ClamPizza;
import ru.mozevil.patterns.factory.simple.model.PepperoniPizza;
import ru.mozevil.patterns.factory.simple.model.Pizza;

/**
 * Created by Женя high 14.08.2017.
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {

        if (type.equalsIgnoreCase("Cheese")) return new CheesePizza();
        if (type.equalsIgnoreCase("Clam")) return new ClamPizza();
        if (type.equalsIgnoreCase("Pepperoni")) return new PepperoniPizza();

        return null;
    }
}
