package clash.deck;

import clash.items.Spell;
import clash.items.Unit;

import java.util.List;

/**
 * Created by Женя on 21.07.2017.
 */
public class Fireball extends Spell {

    private int damage = 100;

    public Fireball() {
        setName("Огненный шар");
        setDescription("Падает с неба. Наносит урон: " + damage);

    }

    @Override
    public synchronized void doSpellEffect(List<Unit> units) {
        for (Unit unit : units) {
            int hp = unit.getHp();
            unit.setHp(hp - damage);
        }
    }
}
