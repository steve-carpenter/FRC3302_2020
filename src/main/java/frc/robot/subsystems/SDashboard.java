package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class SDashboard extends SubsystemBase {

    private RobotContainer m_subsystem;
    private SendableChooser<DRIVE_TYPE> chooser = new SendableChooser<DRIVE_TYPE>();

    public enum DRIVE_TYPE{
        ARCADE,
        TANK
    }

    public SDashboard(RobotContainer robotContainer) {
        robotContainer = this.m_subsystem;
        commandDropDown();
    }

    @Override
    public void periodic() {
        super.periodic();
    }

    private void commandDropDown(){
	    chooser.addObject("Arcade Drive", DRIVE_TYPE.ARCADE);
	    chooser.addDefault("Tank Drive", DRIVE_TYPE.TANK);
	    SmartDashboard.putData("Drive Mode", chooser);
    }

    public DRIVE_TYPE getChooserType(){
        return chooser.getSelected();
    }

    public boolean hasColorWheelOffset() {
        return SmartDashboard.getBoolean("Offset ColorWheel", true);
    }


    
}