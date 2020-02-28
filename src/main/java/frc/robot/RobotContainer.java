package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.controls.JoystickDrive;
import frc.robot.commands.leds.EnableLEDs;
import frc.robot.commands.limelight.AutoAlignChassis;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ColorWheelSpinner;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Inputs;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;

public class RobotContainer {

  public final Drive m_drive = new Drive();
  public final Intake m_intake = new Intake();
  public final Shooter m_shooter = new Shooter();
  public final Climber m_climber = new Climber();
  public final ColorWheelSpinner m_colorwheel = new ColorWheelSpinner();
  public final LED m_led = new LED();
  public final Turret m_turret = new Turret();
  public final Limelight m_limelight = new Limelight();
  public final Conveyor m_conveyor = new Conveyor();
  public final Inputs m_inputs = new Inputs(this);
  public SendableChooser<Boolean> m_tuningSelection = new SendableChooser<>();

  public RobotContainer() {
    addTuningMode();

    CommandScheduler.getInstance().registerSubsystem(m_drive);
    CommandScheduler.getInstance().registerSubsystem(m_intake);
    //CommandScheduler.getInstance().registerSubsystem(m_shooter);
    //CommandScheduler.getInstance().registerSubsystem(m_climber);
    //CommandScheduler.getInstance().registerSubsystem(m_colorwheel);

    //CommandScheduler.getInstance().registerSubsystem(m_led);
    CommandScheduler.getInstance().registerSubsystem(m_turret);
    //CommandScheduler.getInstance().registerSubsystem(m_limelight);
    //CommandScheduler.getInstance().registerSubsystem(m_conveyor);
    
    m_drive.setDefaultCommand(new JoystickDrive(this));
   // m_led.setDefaultCommand(new EnableLEDs(this));
    //m_limelight.setDefaultCommand(new AutoAlignChassis(this));
        
        // Configure the button bindings    
        // configureButtonBindings();
      }

      public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
      }

      private void addTuningMode(){
        m_tuningSelection.addOption("Enabled", true);
        m_tuningSelection.addOption("Disabled", false);
      }
    
}