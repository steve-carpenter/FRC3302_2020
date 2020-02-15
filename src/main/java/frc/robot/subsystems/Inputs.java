package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class Inputs {

    private final Joystick driverControls = new Joystick(0);
    private final Joystick operatorControls = new Joystick(1);

    public Joystick getDriverControls() {
        return driverControls;
    }

    public Joystick getOperatorControls() {
        return operatorControls;
    }

    public double getX(){
        return -1*driverControls.getRawAxis(0);
    }

    public double getY(){
        return -1*driverControls.getRawAxis(1);
    }

    public double getZ(){
        return driverControls.getRawAxis(2);
    }

    public double getZRotate(){
        return -1*driverControls.getRawAxis(3);
    }

	public double getRawAxis(int i) {
		return 0;
	}
}