package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class OpenShooterGate extends CommandBase {

    private RobotContainer m_subsystem;

    public OpenShooterGate(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_shooter,m_subsystem.m_lowGoalGate);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
       m_subsystem.m_lowGoalGate.openGate();
    }

    @Override
    public boolean isFinished() {
        return m_subsystem.m_lowGoalGate.isGateOpen();
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_lowGoalGate.stopGate();
    }

}
