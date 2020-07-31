package ru.mozevil.patterns.adapter;

/**
 * Created by Женя on 18.08.2017.
 */
public class Adapter implements Duck, Turkey {

    private Duck duck;
    private Turkey turkey;

    public Adapter(Duck duck) {
        this.duck = duck;
    }

    public Adapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        if (duck != null) duck.quack();
        if (turkey != null) turkey.gobble();
    }

    @Override
    public void gobble() {
        if (turkey != null) turkey.gobble();
        if (duck != null) duck.quack();
    }

    @Override
    public void fly() {
        if (duck != null) {
            duck.fly();
        }
        if (turkey != null) {
            for (int i = 0; i < 5; i++) {
                turkey.fly();
            }
        }
    }

}
