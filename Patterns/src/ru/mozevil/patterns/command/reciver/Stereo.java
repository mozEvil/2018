package ru.mozevil.patterns.command.reciver;

/**
 * Created by Женя high 17.08.2017.
 */
public class Stereo {

    private String location;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " Stereo ON");
    }

    public void off() {
        System.out.println(location + " Stereo OFF");
    }

    public void setCd() {
        System.out.println(location + " Stereo Set SD");
    }

    public void setDvd() {
        System.out.println(location + " Stereo Set DVD");
    }

    public void setRadio() {
        System.out.println(location + " Stereo Set Radio");
    }

    public void setVolume(int i) {
        System.out.println(location + " Stereo Set Volume: " + i);
    }


}
