package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class ArcadeDrive extends CommandBase {

    private RobotContainer m_subsystem;

    public ArcadeDrive(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_drive);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double leftSpeed = m_subsystem.m_inputs.getDriverControls().getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
		double rightSpeed = m_subsystem.m_inputs.getDriverControls().getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);
		m_subsystem.m_drive.arcadeDrive(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_drive.arcadeDrive(0,0);
    }

}
