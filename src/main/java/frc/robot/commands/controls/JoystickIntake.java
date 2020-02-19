package frc.robot.commands.controls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.commands.limelight.AutoAlign;

public class JoystickIntake extends CommandBase {

    private RobotContainer m_subsystem;

    public JoystickIntake(RobotContainer subsystem){
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_drive, m_subsystem.m_shooter, m_subsystem.m_colorwheel);
    }

    @Override
    public void initialize(){
    }
    @Override
    public void execute(){
    }

    @Override
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return false;
    }
}