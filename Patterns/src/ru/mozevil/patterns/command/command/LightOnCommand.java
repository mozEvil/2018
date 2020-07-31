package ru.mozevil.patterns.command.command;

import ru.mozevil.patterns.command.reciver.Light;

/**
 * Created by Женя high 17.08.2017.
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
