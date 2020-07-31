package ru.mozevil.patterns.adapter;

/**
 * Created by Женя on 18.08.2017.
 */
public class DuckTestDrive {

    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new Adapter(turkey);
        Turkey duckAdapter = new Adapter(duck);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println();
        System.out.println("The Duck says...");
        testDuck(duck);

        System.out.println();
        System.out.println("The Turkey Adapter says...");
        testDuck(turkeyAdapter);
    }

    public static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
