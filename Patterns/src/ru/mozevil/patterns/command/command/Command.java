package ru.mozevil.patterns.command.command;

/**
 * Created by Женя high 17.08.2017.
 */
public interface Command {

    void execute();

    void undo();

//    void load();

//    void store();
}
