package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoAlignChassis extends CommandBase {

    private RobotContainer m_subsystem;
    double KpAim = -0.1;
    double KpDistance = -0.1;
    double min_aim_command = 0.05;
    double left_command = 0.0;
    double right_command = 0.0;
    private final double kDesiredTargetArea = 30.0;

    public AutoAlignChassis(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_limelight, m_subsystem.m_drive);

    }

    @Override
    public void initialize() {
       // SmartDashboard.putNumber("targetArea", m_subsystem.m_limelight.getTA());
       m_subsystem.m_limelight.turnOnLimelightLED();
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("targetArea", m_subsystem.m_limelight.getTA());
        // double heading_error = -m_subsystem.m_limelight.getTX();
        // double distance_error = -m_subsystem.m_limelight.getTY();
        // double steering_adjust = 0.0;

        // double tx = m_subsystem.m_limelight.getTX();

        // if (tx > 1.0)
        // {
        //         steering_adjust = KpAim*heading_error - min_aim_command;
        // }
        // else if (tx < 1.0)
        // {
        //         steering_adjust = KpAim*heading_error + min_aim_command;
        // }

        // double distance_adjust = KpDistance * distance_error;
        // left_command += steering_adjust + distance_adjust;
        // right_command -= steering_adjust + distance_adjust;
        // m_subsystem.m_drive.tankDrive(left_command, right_command);
    }

    @Override
    public boolean isFinished() {
        return m_subsystem.m_limelight.getTA() > kDesiredTargetArea;
    }

    @Override
    public void end(boolean interrupted) {
    }

}
