package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class RetractClimber extends CommandBase {
    private RobotContainer m_subsystem;

    public RetractClimber(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_climber);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystem.m_climber.retractClimber();
    }

    @Override
    public boolean isFinished() {
        return m_subsystem.m_climber.isClimberRetracted();
    }

    @Override
    public void end(boolean interupted) {
        m_subsystem.m_climber.stopClimber();
    }

}
