
package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ExtendClimber extends CommandBase {

    private RobotContainer m_subsystem;

    public ExtendClimber(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_climber);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystem.m_climber.extendClimber();
    }

    @Override
    public boolean isFinished() {
        return m_subsystem.m_climber.isClimberExtended();
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_climber.stopClimber();
    }

}
