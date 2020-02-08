package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoAlign extends CommandBase {

    private final double K = 0.03;                          // how hard to turn toward the target
    private final double DESIRED_TARGET_AREA = 13.0;        // area of the target when the robot reaches the wall                // Simple speed limit so we don't drive too fast
    private final double min_command = 0.05;
    private double steering_adjust;

    public AutoAlign() {

        addRequirements(Robot.limelight, Robot.turret);

    }

    @Override
    public void initialize() {
        steering_adjust = 0.0;
    }

    @Override
    public void execute() {
        double heading_error = -Robot.limelight.getTX();
        steering_adjust = 0.0;
        if (Robot.limelight.getTX() > 1.0)
        {
                steering_adjust = K * heading_error - min_command;
        }
        else if (Robot.limelight.getTX() < 1.0)
        {
                steering_adjust = K * heading_error + min_command;
        }
        Robot.turret.moveTurret(steering_adjust);
    }

    @Override
    public boolean isFinished() {
        return Robot.limelight.getTA() > DESIRED_TARGET_AREA;
    }

    @Override
    public void end(boolean interrupted) {
    }

}
