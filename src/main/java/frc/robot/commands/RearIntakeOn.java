package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 *
 */
public class RearIntakeOn extends CommandBase {

    public RearIntakeOn() {

        addRequirements(Robot.intake);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interupted) {
    }

}
