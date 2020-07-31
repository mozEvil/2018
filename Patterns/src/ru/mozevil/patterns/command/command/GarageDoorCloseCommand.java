package ru.mozevil.patterns.command.command;

import ru.mozevil.patterns.command.reciver.GarageDoor;

/**
 * Created by Женя high 17.08.2017.
 */
public class GarageDoorCloseCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
