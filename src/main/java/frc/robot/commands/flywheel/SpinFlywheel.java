package frc.robot.commands.flywheel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.utils.TunableNumber;

public class SpinFlywheel extends CommandBase {

    private RobotContainer m_subsystem;
    private TunableNumber setpoint = new TunableNumber("Shooter FlyWheel RPM");

  public SpinFlywheel(RobotContainer subsystem, Double rpm) {
    addRequirements(m_subsystem.m_shooter);
    setpoint.setDefault(rpm);
  }

  public SpinFlywheel(RobotContainer subsystem) {
    addRequirements(m_subsystem.m_shooter);
    setpoint.setDefault(6000);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // shooterFlyWheel.run(setpoint.get());
    m_subsystem.m_shooter.setSetpoint(setpoint.get());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (SmartDashboard.getBoolean("tuningMode", true)) {
      m_subsystem.m_shooter.setSetpoint(setpoint.get());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.m_shooter.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}