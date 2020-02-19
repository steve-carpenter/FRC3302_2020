package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotContainer;
import frc.robot.commands.limelight.AutoAlign;
import frc.robot.utils.TunableBoolean;

public class Inputs {

    private RobotContainer m_subsystem;

    public Inputs(RobotContainer robotcontainer) {
        m_subsystem = robotcontainer;
        configureButtons();
	}

	private final Joystick driverControls = new Joystick(0);
    private final Joystick operatorControls = new Joystick(1);
    private final TunableBoolean m_manualMode = new TunableBoolean("Manual Operator Control", false);
    private final double m_deadband = 0.09;

    public Joystick getDriverControls() {
        return driverControls;
    }

    public Joystick getOperatorControls() {
        return operatorControls;
    }

    public JoystickButton getOpTrigger(){
        return getOperatorButton(1);
    }
    
    private JoystickButton getOperatorButton(int buttonId){
        return new JoystickButton(operatorControls,buttonId);
    }

    private JoystickButton getDriverButton(int buttonId){
        return new JoystickButton(driverControls,buttonId);
    }

    public double getX(){
        return processJoystickAxis(driverControls.getRawAxis(0),-1);
    }

    public double getY(){
        return processJoystickAxis(driverControls.getRawAxis(1),-1);
    }

    public double getZ(){
        return processJoystickAxis(driverControls.getRawAxis(2));
    }

    public double getZRotate(){
        return processJoystickAxis(driverControls.getRawAxis(3),-1);
    }
    
    private double processJoystickAxis(double joystickAxis) {
        return Math.abs(joystickAxis) > m_deadband ? joystickAxis * Math.abs(joystickAxis) * 1 : 0;
    }
    private double processJoystickAxis(double joystickAxis, int multiply) {
        return Math.abs(joystickAxis) > m_deadband ? joystickAxis * Math.abs(joystickAxis) * multiply : 0;
    }

    private void configureButtons(){
        if(m_manualMode.get()){

        }
        else{
            getOpTrigger().whenPressed(new AutoAlign(m_subsystem));
        }
      
    }
}