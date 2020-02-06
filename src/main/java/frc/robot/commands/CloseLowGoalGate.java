package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class CloseLowGoalGate extends CommandBase {

    public CloseLowGoalGate() {

        addRequirements(Robot.lowGoalGate);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.lowGoalGate.closeGate();
    }

    @Override
    public boolean isFinished() {
        return Robot.lowGoalGate.isGateClosed();
    }

    @Override
    public void end(boolean interrupted) {
        Robot.lowGoalGate.stopGate();
    }
}
