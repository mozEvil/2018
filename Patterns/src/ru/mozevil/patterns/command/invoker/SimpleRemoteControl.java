package ru.mozevil.patterns.command.invoker;

import ru.mozevil.patterns.command.command.Command;

/**
 * Created by Женя high 17.08.2017.
 */

/**
 * Invoker
 */
public class SimpleRemoteControl {

    private Command slot;

    public SimpleRemoteControl() {}

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
