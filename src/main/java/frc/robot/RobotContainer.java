package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.EnableLEDs;
import frc.robot.commands.controls.JoystickDrive;
import frc.robot.commands.controls.JoystickIntake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ColorWheelSpinner;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Inputs;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.LowGoalGate;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.utils.motors.configurations.ClimberMotorConfiguration;
import frc.robot.utils.motors.configurations.FlywheelMotorConfiguration;

public class RobotContainer {

  public final Drive m_drive = new Drive();
  public final Intake m_intake = new Intake();
  public final Shooter m_shooter = new Shooter(new FlywheelMotorConfiguration());
  public final Climber m_climber = new Climber(new ClimberMotorConfiguration());
  public final ColorWheelSpinner m_colorwheel = new ColorWheelSpinner();
  public final LowGoalGate m_lowGoalGate = new LowGoalGate();
  public final LED m_led = new LED();
  public final Inputs m_inputs = new Inputs();
  public final Turret m_turret = new Turret();
  public final Limelight m_limelight = new Limelight();
  public final Conveyor m_conveyor = new Conveyor();

  public RobotContainer() {
    CommandScheduler.getInstance().registerSubsystem(m_drive);
    CommandScheduler.getInstance().registerSubsystem(m_intake);

    m_intake.setDefaultCommand(new JoystickIntake(this, 0.0));
    m_drive.setDefaultCommand(new JoystickDrive(this));
    m_led.setDefaultCommand(new EnableLEDs(this));
        
        // Configure the button bindings    
        // configureButtonBindings();
      }

      public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
      }
    
}