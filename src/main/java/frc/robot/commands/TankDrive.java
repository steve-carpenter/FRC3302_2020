// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TankDrive extends CommandBase {

    public TankDrive() {

        addRequirements(Robot.drive);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double moveSpeed = -Robot.oi.driverControls.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
		double rotateSpeed = Robot.oi.driverControls.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);
		Robot.drive.tankDrive(moveSpeed, rotateSpeed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.drive.tankDrive(0, 0);
    }
}
