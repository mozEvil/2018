package ru.mozevil.patterns.factory.abstrct.factory;

import ru.mozevil.patterns.factory.abstrct.ingredient.*;

/**
 * Created by Женя high 14.08.2017.
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
