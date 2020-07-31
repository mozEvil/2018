package ru.mozevil.patterns.factory.abstrct.store;

import ru.mozevil.patterns.factory.abstrct.factory.NYPizzaIngredientFactory;
import ru.mozevil.patterns.factory.abstrct.factory.PizzaIngredientFactory;
import ru.mozevil.patterns.factory.abstrct.pizza.CheesePizza;
import ru.mozevil.patterns.factory.abstrct.pizza.ClamPizza;
import ru.mozevil.patterns.factory.abstrct.pizza.Pizza;

/**
 * Created by Женя high 14.08.2017.
 */
public class NYPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        //some logic here ...
        if (type.equalsIgnoreCase("cheese")) {

            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");

        } else if (type.equalsIgnoreCase("clam")) {

            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }

        return pizza;
    }
}
