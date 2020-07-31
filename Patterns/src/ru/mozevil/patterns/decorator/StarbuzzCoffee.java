package ru.mozevil.patterns.decorator;

import ru.mozevil.patterns.decorator.model.*;

/**
 * Created by Женя high 13.08.2017.
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {

        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new Whip(new Mocha(new Soy(new HouseBlend())));
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

    }
}
