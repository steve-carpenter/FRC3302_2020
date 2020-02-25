package frc.robot.commands.controls;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        switch(m_subsystem.m_drive.getChooserType()){
            case ARCADE:{
                m_subsystem.m_drive.arcadeDrive(m_subsystem.m_inputs.getY(), m_subsystem.m_inputs.getZ());
                break;
            }
            case TANK:
            default:{
                m_subsystem.m_drive.tankDrive(m_subsystem.m_inputs.getY(), m_subsystem.m_inputs.getZRotate());
                break;
            }
            }
        }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }


}