package ru.mozevil.patterns.command.client;

import ru.mozevil.patterns.command.command.*;
import ru.mozevil.patterns.command.invoker.RemoteControlWithUndo;
import ru.mozevil.patterns.command.reciver.CeilingFan;
import ru.mozevil.patterns.command.reciver.GarageDoor;
import ru.mozevil.patterns.command.reciver.Light;
import ru.mozevil.patterns.command.reciver.Stereo;

/**
 * Created by Женя high 17.08.2017.
 */
public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        CeilingFan fan = new CeilingFan("Living Room");

        CeilingFanHighCommand fanHigh = new CeilingFanHighCommand(fan);
        CeilingFanMediumCommand fanMedium = new CeilingFanMediumCommand(fan);
        CeilingFanLowCommand fanLow = new CeilingFanLowCommand(fan);
        CeilingFanOffCommand fanOff = new CeilingFanOffCommand(fan);

        Command[] partyOn = {fanHigh, fanMedium, fanLow, fanHigh};
        Command[] partyOff = {fanOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(0);



//        Light livingRoomLight = new Light("Living Room");
//        Light kitchenLight = new Light("Kitchen");
//        CeilingFan ceilingFan = new CeilingFan("Living Room");
//        GarageDoor garageDoor = new GarageDoor("");
//        Stereo stereo = new Stereo("Living Room");
//
//        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
//        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
//        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
//        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
//
//        CeilingFanHighCommand ceilingFanOn = new CeilingFanHighCommand(ceilingFan);
//        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
//
//        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
//        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);
//
//        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
//        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
//
//        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
//        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
//        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
//        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
//
//        System.out.println(remoteControl);
//
//        remoteControl.onButtonWasPushed(0);
//        remoteControl.offButtonWasPushed(0);
//        remoteControl.undoButtonWasPushed();
//        System.out.println(remoteControl);
//        remoteControl.onButtonWasPushed(1);
//        remoteControl.undoButtonWasPushed();
//        remoteControl.offButtonWasPushed(1);
//        remoteControl.onButtonWasPushed(2);
//        remoteControl.offButtonWasPushed(2);
//        remoteControl.undoButtonWasPushed();
//        remoteControl.onButtonWasPushed(3);
//        remoteControl.offButtonWasPushed(3);

    }
}
