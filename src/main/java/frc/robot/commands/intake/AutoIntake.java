
package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class AutoIntake extends CommandBase {

    private RobotContainer m_subsystem;

    public AutoIntake(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_intake);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystem.m_intake.run(RobotMap.INTAKE_COLLECT_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_intake.run(0);
    }

}
