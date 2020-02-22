
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SpinNumberOfTimes extends CommandBase {
    private RobotContainer m_subsystem;
    private double m_numberOfSpins;

    public SpinNumberOfTimes(RobotContainer subsystem, double numberOfSpins) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_colorwheel);
        m_numberOfSpins = numberOfSpins;
    }

    @Override
    public void initialize() {
        SmartDashboard.putNumber("Number of spins", m_numberOfSpins);
    }

    @Override
    public void execute() {
        m_subsystem.m_colorwheel.spinNumberOfTimes(m_numberOfSpins);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_colorwheel.stopColorWheel();
    }
}
