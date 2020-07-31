package ru.mozevil.patterns.factory.method;


import ru.mozevil.patterns.factory.method.model.Pizza;

/**
 * Created by Женя high 14.08.2017.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {

        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
