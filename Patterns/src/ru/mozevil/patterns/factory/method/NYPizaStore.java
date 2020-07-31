package ru.mozevil.patterns.factory.method;

import ru.mozevil.patterns.factory.method.model.NYStyleCheesePizza;
import ru.mozevil.patterns.factory.method.model.Pizza;

/**
 * Created by Женя high 14.08.2017.
 */
public class NYPizaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        //some logic
        return new NYStyleCheesePizza();
    }
}
