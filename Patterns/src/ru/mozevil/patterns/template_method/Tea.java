package ru.mozevil.patterns.template_method;

/**
 * Created by Женя on 23.08.2017.
 */
public class Tea extends CaffeineBeverage {

    protected void brew() {
        System.out.println("Steeping the tea");
    }

    protected void addCondiments() {
        System.out.println("Adding Lemon");
    }

}
