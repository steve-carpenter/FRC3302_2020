package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class Inputs {

    Joystick driverControls = new Joystick(0);
    Joystick operatorControls = new Joystick(1);

    public Joystick getDriverControls() {
        return driverControls;
    }

    public Joystick getOperatorControls() {
        return operatorControls;
    }
}