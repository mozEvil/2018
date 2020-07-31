package ru.mozevil.patterns.template_method;

/**
 * Created by Женя on 23.08.2017.
 */
public class Coffee extends CaffeineBeverage{

    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
