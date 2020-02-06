package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 *
 */
public class OpenLowGoalGate extends CommandBase {

    public OpenLowGoalGate() {

        addRequirements(Robot.lowGoalGate);

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
    public void end(boolean interruped) {
    }

}
