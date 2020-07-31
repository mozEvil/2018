package ru.mozevil.patterns.command.command;

/**
 * Created by Женя on 17.08.2017.
 */
public class MacroCommand implements Command {

    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }

    @Override
    public void undo() {
        for (Command cmd : commands) {
            cmd.undo();
        }
    }
}
