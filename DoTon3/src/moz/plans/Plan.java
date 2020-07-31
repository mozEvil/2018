package moz.plans;

/**
 * Created by mozEvil on 03.11.2016.
 */
public class Plan {

    private String name;
    private int chance_base;
    private int chance_now;

    public Plan() {
    }

    public Plan(String name, int chance_base, int chance_now) {
        this.name = name;
        this.chance_base = chance_base;
        this.chance_now = chance_now;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChance_base() {
        return chance_base;
    }

    public void setChance_base(int chance_base) {
        this.chance_base = chance_base;
    }

    public int getChance_now() {
        return chance_now;
    }

    public void setChance_now(int chance_now) {
        this.chance_now = chance_now;
    }

}
