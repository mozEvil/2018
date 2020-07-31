package ru.mozevil.patterns.command.command;

import ru.mozevil.patterns.command.reciver.GarageDoor;

/**
 * Created by Женя high 17.08.2017.
 */
public class GarageDoorOpenCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
            garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
