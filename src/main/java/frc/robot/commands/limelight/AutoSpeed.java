package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class AutoSpeed extends CommandBase {

    private RobotContainer m_subsystem;
    private double distance = 0.0;
    private final double INNER_PORT_HEIGHT = 98.25;
    private final double CAMERA_HEIGHT = 45;
    private final double CAMERA_ANGLE_TOP = 10;
    private final double CAMERA_ANGLE_BOTTOM = 35;

    public AutoSpeed(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_limelight, m_subsystem.m_shooter);

    }

    @Override
    public void initialize() {
        distance = 0.0;
    }

    @Override
    public void execute() {
        measureDistance();
        m_subsystem.m_shooter.setFlywheelSpeed(m_subsystem.m_shooter.distanceToSpeed(distance));
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
