package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class AutoIndexBall extends SequentialCommandGroup {

  private RobotContainer m_subsystem;
   
    public AutoIndexBall(RobotContainer subsystem) {
      m_subsystem = subsystem;
      addCommands(
        new MoveBallToLocation1(m_subsystem), 
        new MoveBallToLocation2(m_subsystem), 
        new MoveBallToLocation3(m_subsystem),
        new MoveBallToLocation4(m_subsystem));
    }
  
  }