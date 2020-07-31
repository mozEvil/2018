package ru.mozevil.patterns.command.command;

import ru.mozevil.patterns.command.reciver.CeilingFan;

/**
 * Created by Женя high 17.08.2017.
 */
public class CeilingFanLowCommand implements Command{

    private CeilingFan fan;
    private int prevSpeed;

    public CeilingFanLowCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.low();
    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case CeilingFan.HIGH: { fan.high(); break; }
            case CeilingFan.MEDIUM: { fan.medium(); break; }
            case CeilingFan.LOW: { fan.low(); break; }
            case CeilingFan.OFF: { fan.off(); break; }
        }
    }
}
