package clash.items;

import clash.controllers.Navigator;
import clash.controllers.TargetManager;

/**
 * Created by Женя on 21.07.2017.
 */
public abstract class Unit extends Item {

    private int hp;
    private boolean isLive;
    private int damage;
    private double attackRate;
    private int attackDistance;
    private int attackRadius;

    private int x;
    private int y;

    private int unitSize;

    public int getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(int unitSize) {
        this.unitSize = unitSize;
    }

    @Override
    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    private TargetManager targetManager;
    private Navigator navigator;

    public TargetManager getTargetManager() {
        return targetManager;
    }

    public void setTargetManager(TargetManager targetManager) {
        this.targetManager = targetManager;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public int getAttackRadius() {
        return attackRadius;
    }

    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    public void setAttackDistance(int attackDistance) {
        this.attackDistance = attackDistance;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(double attackRate) {
        this.attackRate = attackRate;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }




}
