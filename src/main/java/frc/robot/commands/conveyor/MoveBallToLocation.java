package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 *
 */
public abstract class MoveBallToLocation extends CommandBase {

    public MoveBallToLocation() {

        addRequirements(Robot.conveyor);


    }

    protected abstract void runConveyor();
    protected abstract void stopConveyor();
    protected abstract boolean isBallPresent();

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        runConveyor();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return isBallPresent();
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        stopConveyor();
    }

}
