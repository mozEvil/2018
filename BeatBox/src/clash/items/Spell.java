package clash.items;

import java.util.List;

/**
 * Created by Женя on 21.07.2017.
 */
public abstract class Spell extends Item {

    public abstract void doSpellEffect(List<Unit> units);

}
