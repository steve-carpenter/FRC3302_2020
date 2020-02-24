package frc.robot.commands.shooterGate;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class OpenShooterGate extends CommandBase {

    private RobotContainer m_subsystem;

    public OpenShooterGate(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_shooter);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
       m_subsystem.m_shooter.openShooterGate();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_shooter.stopShooterGate();
    }

}
