package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.colorwheel.SpinToColor;
import frc.robot.commands.colorwheel.SpinToColor.SpinnerColor;

public class SDashboard extends SubsystemBase {

    private RobotContainer m_subsystem;
    private SendableChooser<DRIVE_TYPE> chooser = new SendableChooser<DRIVE_TYPE>();
    private SendableChooser<Command> colorSelection = new SendableChooser<Command>();

    public enum DRIVE_TYPE{
        ARCADE,
        TANK
    }

    public SDashboard(RobotContainer robotContainer) {
        robotContainer = this.m_subsystem;
        SmartDashboard.setDefaultBoolean("tuningMode", true);
        commandDropDown();
        smartDashboardSetup();
    }

    @Override
    public void periodic() {
        super.periodic();
    }

    private void commandDropDown(){
	    chooser.addOption("Arcade Drive", DRIVE_TYPE.ARCADE);
	    chooser.setDefaultOption("Tank Drive", DRIVE_TYPE.TANK);
	    SmartDashboard.putData("Drive Mode", chooser);
    }

    public DRIVE_TYPE getChooserType(){
        return chooser.getSelected();
    }

    public boolean hasColorWheelOffset() {
        return SmartDashboard.getBoolean("Offset ColorWheel", true);
    }

    private void smartDashboardSetup(){
        colorSelection.addOption("Red", new SpinToColor(m_subsystem, SpinnerColor.RED));
        colorSelection.addOption("Blue", new SpinToColor(m_subsystem, SpinnerColor.BLUE));
        colorSelection.addOption("Green", new SpinToColor(m_subsystem, SpinnerColor.GREEN));
        colorSelection.addOption("Yellow", new SpinToColor(m_subsystem, SpinnerColor.YELLOW));
        SmartDashboard.putData("Color Selection", colorSelection);
    }


    
}