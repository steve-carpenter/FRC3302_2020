package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class JoystickDrive extends CommandBase {
    private RobotContainer m_subsystem;

    public JoystickDrive(RobotContainer subsystem){
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_drive);
    }

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute(){
        double leftSpeed = m_subsystem.m_inputs.getDriverControls().getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
		double rightSpeed = m_subsystem.m_inputs.getDriverControls().getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);
        m_subsystem.m_drive.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
}