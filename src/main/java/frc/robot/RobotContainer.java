package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ColorWheelSpinner;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

    public final Drive m_drive = new Drive();
    public final Intake m_intake = new Intake();
    // public Shooter m_shooter = new Shooter();
    // public Climber m_climber = new Climber();
    public ColorWheelSpinner m_colorwheel = new ColorWheelSpinner();
    public LED m_led = new LED();

    public RobotContainer() {
        CommandScheduler.getInstance().registerSubsystem(m_drive);
        CommandScheduler.getInstance().registerSubsystem(m_intake);
        
        m_intake.setDefaultCommand(new JoystickIntake(this, 0.0));
        m_drive.setDefaultCommand(m_JoystickDrive);
        
        // Configure the button bindings    
        // configureButtonBindings();
      }

      public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
      }
    
}