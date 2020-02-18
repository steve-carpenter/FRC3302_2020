package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoAlign extends CommandBase {
    
    private RobotContainer m_subsystem;
    private final double K = 0.03;                          // how hard to turn toward the target
    private final double DESIRED_TARGET_AREA = 13.0;        // area of the target when the robot reaches the wall                // Simple speed limit so we don't drive too fast
    private final double min_command = 0.05;
    private double steering_adjust;

    public AutoAlign(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_limelight, m_subsystem.m_turret);

    }

    @Override
    public void initialize() {
        steering_adjust = 0.0;
    }

    @Override
    public void execute() {
        double heading_error = -m_subsystem.m_limelight.getTX();
        steering_adjust = 0.0;
        if (m_subsystem.m_limelight.getTX() > 1.0)
        {
                steering_adjust = K * heading_error - min_command;
        }
        else if (m_subsystem.m_limelight.getTX() < 1.0)
        {
                steering_adjust = K * heading_error + min_command;
        }
        m_subsystem.m_turret.moveTurret(steering_adjust);
    }

    @Override
    public boolean isFinished() {
        return m_subsystem.m_limelight.getTX() < 0.05 && m_subsystem.m_limelight.getTX() > -0.05;
    }

    @Override
    public void end(boolean interrupted) {
    }

}
