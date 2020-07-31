package ru.mozevil.patterns.command.reciver;

/**
 * Created by Женя high 17.08.2017.
 */
public class GarageDoor {

    private String location;

    public GarageDoor(String location) {
        this.location = location;
    }

    public void up() {
        System.out.println(location + " Garage Door is OPEN");
    }

    public void down() {
        System.out.println(location + " Garage Door is CLOSED");
    }

    public void stop() {
        System.out.println(location + " Garage Door is STOPPED");
    }

    public void lightOn() {
        System.out.println(location + " Garage Light ON");
    }

    public void lightOff() {
        System.out.println(location + " Garage Light OFF");
    }
}
