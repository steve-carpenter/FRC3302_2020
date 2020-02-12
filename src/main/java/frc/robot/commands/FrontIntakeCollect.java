
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class FrontIntakeCollect extends CommandBase {

    private RobotContainer m_subsystem;

    public FrontIntakeCollect(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_intake);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystem.m_intake.intakeFront(RobotMap.INTAKE_COLLECT_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_intake.intakeFront(0);
    }

}
