package ru.mozevil.patterns.command.reciver;

/**
 * Created by Женя high 17.08.2017.
 */
public class Light {

    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is ON");
    }

    public void off() {
        System.out.println(location + " light is OFF");
    }
}
