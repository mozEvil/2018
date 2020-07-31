package ru.mozevil.patterns.command.command;

import ru.mozevil.patterns.command.reciver.Stereo;

/**
 * Created by Женя high 17.08.2017.
 */
public class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }
}
