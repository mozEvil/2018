package clash.deck;

import clash.actions.CanAttack;
import clash.controllers.TargetManager;
import clash.items.Unit;

import java.awt.*;

/**
 * Created by Женя on 21.07.2017.
 */
public class Castle extends Unit implements CanAttack {

    private final static int UNIT_SIZE = 30;

    public Castle() {
        setName("Замок");
        setDescription("Уровень 1");
        setHp(1000);
        setLive(true);
        setDamage(100);
        setAttackRate(1.0);
        setAttackDistance(10);
        setAttackRadius(1);
        setTargetManager(new TargetManager());
        setUnitSize(UNIT_SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, UNIT_SIZE, UNIT_SIZE);
    }

    @Override
    public void attack(Unit unit) {

    }
}
