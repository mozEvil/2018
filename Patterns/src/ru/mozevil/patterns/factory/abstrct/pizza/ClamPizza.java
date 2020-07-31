package ru.mozevil.patterns.factory.abstrct.pizza;

import ru.mozevil.patterns.factory.abstrct.factory.PizzaIngredientFactory;

/**
 * Created by Женя high 14.08.2017.
 */
public class ClamPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClam();
    }
}
