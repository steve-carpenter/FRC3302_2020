package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoSpeed extends CommandBase {

    private double distance = 0.0;
    private final double INNER_PORT_HEIGHT = 98.25;
    private final double CAMERA_HEIGHT = 45;
    private final double CAMERA_ANGLE_TOP = 10;
    private final double CAMERA_ANGLE_BOTTOM = 35;

    public AutoSpeed() {

        addRequirements(Robot.limelight, Robot.shooter);

    }

    @Override
    public void initialize() {
        distance = 0.0;
    }

    @Override
    public void execute() {
        measureDistance();
        Robot.shooter.setFlywheelSpeed(Robot.shooter.distanceToSpeed(distance));
        // TODO what next?
    }

    @Override
    public boolean isFinished() {
        return false; // finish this when at speed?
    }

    @Override
    public void end(boolean interrupted) {
    }

    private void measureDistance(){
        distance = (INNER_PORT_HEIGHT-CAMERA_HEIGHT) / Math.tan(CAMERA_ANGLE_TOP + CAMERA_ANGLE_BOTTOM);
    }
}
