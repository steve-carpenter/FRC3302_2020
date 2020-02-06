package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class MoveBall extends SequentialCommandGroup {
   
    public MoveBall() {
      addCommands(new MoveBallToLocation1(), new MoveBallToLocation2(), new MoveBallToLocation3(),new MoveBallToLocation4());
    }
  
  }