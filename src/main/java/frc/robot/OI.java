// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CloseLowGoalGate;
import frc.robot.commands.CloseShooterGate;
import frc.robot.commands.ExtendClimber;
import frc.robot.commands.ManualShoot;
import frc.robot.commands.OpenLowGoalGate;
import frc.robot.commands.OpenShooterGate;
import frc.robot.commands.RearIntakeOn;
import frc.robot.commands.RetractClimber;
import frc.robot.commands.SpeedUpFlywheel;
import frc.robot.commands.conveyor.MoveBall;
import frc.robot.commands.limelight.AutoAlignSpeed;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

public Joystick driverControls;
public JoystickButton doClimb;
public JoystickButton doUnclimb;
public Joystick operatorControls;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

operatorControls = new Joystick(1);

// doUnclimb = new JoystickButton(operatorControls, 2);
// doUnclimb.whenPressed(new RetractClimber());
// doClimb = new JoystickButton(operatorControls, 1);
// doClimb.whenPressed(new ExtendClimber());
driverControls = new Joystick(0);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getDriverControls() {
        return driverControls;
    }

public Joystick getOperatorControls() {
        return operatorControls;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

