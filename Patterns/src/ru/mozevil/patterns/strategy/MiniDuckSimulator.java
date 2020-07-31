package ru.mozevil.patterns.strategy;

import ru.mozevil.patterns.strategy.behaviors.fly.FlyRocketPowered;
import ru.mozevil.patterns.strategy.model.Duck;
import ru.mozevil.patterns.strategy.model.MallardDuck;
import ru.mozevil.patterns.strategy.model.ModelDuck;

/**
 * Created by Женя high 11.08.2017.
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
