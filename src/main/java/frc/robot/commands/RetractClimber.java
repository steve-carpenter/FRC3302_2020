package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class RetractClimber extends CommandBase {

    public RetractClimber() {

        addRequirements(Robot.climber);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.climber.retractClimber();
    }

    @Override
    public boolean isFinished() {
        return Robot.climber.isClimberRetracted();
    }

    @Override
    public void end(boolean interupted) {
        Robot.climber.stopClimber();
    }

}
