package ru.mozevil.patterns.command.reciver;

/**
 * Created by Женя high 17.08.2017.
 */
public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println(location + " Ceiling Fan is HIGH");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " Ceiling Fan is MEDIUM");
    }

    public void low() {
        speed = LOW;
        System.out.println(location + " Ceiling Fan is LOW");
    }

    public void off() {
        speed = OFF;
        System.out.println(location + " Ceiling Fan is OFF");
    }

    public int getSpeed() {
        return speed;
    }
}
