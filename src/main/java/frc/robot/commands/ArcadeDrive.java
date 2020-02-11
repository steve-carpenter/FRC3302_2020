package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeDrive extends CommandBase {

    public ArcadeDrive() {

        addRequirements(Robot.drive);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double leftSpeed = Robot.oi.driverControls.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
		double rightSpeed = Robot.oi.driverControls.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);
		Robot.drive.arcadeDrive(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.drive.arcadeDrive(0,0);
    }

}
