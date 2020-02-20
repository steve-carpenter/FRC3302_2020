package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoFireEntireConveyor extends CommandBase{

    private RobotContainer m_subsystem;

    public AutoFireEntireConveyor(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_conveyor);
    }

   // Called just before this Command runs the first time
    @Override
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        m_subsystem.m_conveyor.runTopConveyor();
        m_subsystem.m_conveyor.runBottomConveyor();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return m_subsystem.m_conveyor.isConveyorEmpty();
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_conveyor.stopTopConveyor();
        m_subsystem.m_conveyor.stopBottomConveyor();
    }
        
}