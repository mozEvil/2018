package ru.mozevil.patterns.command.command;

import ru.mozevil.patterns.command.reciver.Light;

/**
 * Created by Женя high 17.08.2017.
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
