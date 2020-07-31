package ru.mozevil.patterns.command.client;

import ru.mozevil.patterns.command.command.GarageDoorOpenCommand;
import ru.mozevil.patterns.command.command.LightOnCommand;
import ru.mozevil.patterns.command.invoker.SimpleRemoteControl;
import ru.mozevil.patterns.command.reciver.GarageDoor;
import ru.mozevil.patterns.command.reciver.Light;

/**
 * Created by Женя high 17.08.2017.
 */

/**
 * Client
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        LightOnCommand lightOn = new LightOnCommand(new Light(""));
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(new GarageDoor(""));

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageDoorOpen);
        remote.buttonWasPressed();

    }
}
