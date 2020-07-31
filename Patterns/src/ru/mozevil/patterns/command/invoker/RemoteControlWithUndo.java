package ru.mozevil.patterns.command.invoker;

import ru.mozevil.patterns.command.command.Command;
import ru.mozevil.patterns.command.command.NoCommand;

/**
 * Created by Женя high 17.08.2017.
 */
public class RemoteControlWithUndo {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------- Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("{slot ").append(i).append("] ").append(onCommands[i].getClass().getName());
            sb.append("   ").append(offCommands[i].getClass().getName()).append("\n");
        }
        sb.append("[undo]").append(undoCommand.getClass().getName()).append("\n");
        return sb.toString();
    }
}
