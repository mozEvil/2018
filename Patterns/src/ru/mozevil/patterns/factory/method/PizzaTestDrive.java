package ru.mozevil.patterns.factory.method;

import ru.mozevil.patterns.factory.method.model.Pizza;

/**
 * Created by Женя high 14.08.2017.
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizaStore();
        PizzaStore ChicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = ChicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
