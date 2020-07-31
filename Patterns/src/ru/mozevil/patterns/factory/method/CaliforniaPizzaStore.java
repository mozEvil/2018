package ru.mozevil.patterns.factory.method;

import ru.mozevil.patterns.factory.method.model.CaliforniaStylePepperoniPizza;
import ru.mozevil.patterns.factory.method.model.Pizza;

/**
 * Created by Женя high 14.08.2017.
 */
public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        //some logic here
        return new CaliforniaStylePepperoniPizza();
    }
}
