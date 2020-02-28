package frc.robot.commands.lowGoalGate;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class CloseLowGoalGate extends CommandBase {

    private RobotContainer m_subsystem;

    public CloseLowGoalGate(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_lowGoalGate);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystem.m_lowGoalGate.closeGate();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_lowGoalGate.stopGate();
    }
}
