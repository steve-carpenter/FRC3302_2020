package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotContainer;
import frc.robot.commands.limelight.AutoAlign;
import frc.robot.commands.limelight.AutoSpeed;
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
    // private final Command m_autoCommand =
    //   // Start the command by spinning up the shooter...
    //   new InstantCommand(m_subsystem.m_shooter::enable, m_subsystem.m_shooter).andThen(
    //       new InstantCommand(()-> m_subsystem.m_shooter.setSetpoint(300)),
    //       // Wait until the shooter is at speed before feeding the frisbees
    //       new WaitUntilCommand(m_subsystem.m_shooter::atSetpoint),
    //       // Start running the feeder
    //       new WaitCommand(20))
    //       // Add a timeout (will end the command if, for instance, the shooter never gets up to
    //       // speed)
    //       .withTimeout(10)
    //       // When the command ends, turn off the shooter and the feeder
    //       .andThen(() -> {
    //         m_subsystem.m_shooter.disable();

    //       });

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
            getOperatorButton(2).whenActive(new InstantCommand(() -> m_subsystem.m_intake.collect()));
            getOperatorButton(2).whenActive(new InstantCommand(() -> m_subsystem.m_intake.uncollect()));
            getOperatorButton(6).whenActive(new InstantCommand(() -> m_subsystem.m_climber.extendClimber()));
            getOperatorButton(4).whenActive(new InstantCommand(() -> m_subsystem.m_climber.retractClimber()));

        }
        else{
            getOpTrigger().whenPressed(new AutoSpeed(m_subsystem));
            getOperatorButton(6).whenActive(new InstantCommand(() -> m_subsystem.m_climber.extendClimber()));
            getOperatorButton(4).whenActive(new InstantCommand(() -> m_subsystem.m_climber.retractClimber()));
        }
      
    }
}