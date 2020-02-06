
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ExtendClimber extends CommandBase {

    public ExtendClimber() {

        addRequirements(Robot.climber);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.climber.extendClimber();
    }

    @Override
    public boolean isFinished() {
        return Robot.climber.isClimberExtended();
    }

    @Override
    public void end(boolean interrupted) {
        Robot.climber.stopClimber();
    }

}
