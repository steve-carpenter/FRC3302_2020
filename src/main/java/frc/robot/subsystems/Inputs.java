package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class Inputs {

    private final Joystick driverControls = new Joystick(0);
    private final Joystick operatorControls = new Joystick(1);

    public Joystick getDriverControls() {
        return driverControls;
    }

    public Joystick getOperatorControls() {
        return operatorControls;
    }
}