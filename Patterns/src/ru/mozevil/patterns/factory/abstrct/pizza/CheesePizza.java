package ru.mozevil.patterns.factory.abstrct.pizza;

import ru.mozevil.patterns.factory.abstrct.factory.PizzaIngredientFactory;

/**
 * Created by Женя high 14.08.2017.
 */
public class CheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
