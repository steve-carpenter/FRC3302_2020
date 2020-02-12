package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

/**
 *
 */
public class RearIntakeOn extends CommandBase {

    private RobotContainer m_subsystem;
    
    public RearIntakeOn(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_intake);

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
    public void end(boolean interupted) {
    }

}
