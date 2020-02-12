package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class AutoAlignSpeed extends SequentialCommandGroup {

    private RobotContainer m_subsystem;

    public AutoAlignSpeed(RobotContainer subsystem) {
        m_subsystem = subsystem;
        parallel(new AutoAlign(m_subsystem), new AutoSpeed(m_subsystem));
    }

    public boolean isFinished() {
        return false;
        
    }
  
  }