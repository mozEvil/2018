package ru.mozevil.patterns.factory.method;

import ru.mozevil.patterns.factory.method.model.ChicagoStyleCheesePizza;
import ru.mozevil.patterns.factory.method.model.Pizza;

/**
 * Created by Женя high 14.08.2017.
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        //some logic here
        return new ChicagoStyleCheesePizza();
    }
}
