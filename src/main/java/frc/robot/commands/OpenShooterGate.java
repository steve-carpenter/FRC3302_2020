package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class OpenShooterGate extends CommandBase {

    public OpenShooterGate() {

        addRequirements(Robot.shooter);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.lowGoalGate.openGate();
    }

    @Override
    public boolean isFinished() {
        return Robot.lowGoalGate.isGateOpen();
    }

    @Override
    public void end(boolean interrupted) {
        Robot.lowGoalGate.stopGate();
    }

}
