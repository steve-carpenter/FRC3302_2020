package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/**
 *
 */
public abstract class MoveBallToLocation extends CommandBase {

    private RobotContainer m_subsystem;

    public MoveBallToLocation(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_conveyor);
    }

    protected abstract void runConveyor();
    protected abstract void stopConveyor();
    protected abstract boolean isBallPresent();
    protected abstract boolean canIndex();
    protected abstract String getConveyorId();
    
    protected RobotContainer getSubSystem(){
        return m_subsystem;
    }


    // Called just before this Command runs the first time
    @Override
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        runConveyor();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return isBallPresent() && canIndex();
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        stopConveyor();
    }

    public void logging(){
        SmartDashboard.putBoolean(getConveyorId(), isBallPresent());

    }

}
