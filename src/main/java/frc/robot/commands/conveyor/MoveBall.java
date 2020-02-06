package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class MoveBall extends SequentialCommandGroup {
    /**
     * Creates a new ComplexAuto.
     *
     * @param drive The drive subsystem this command will run on
     * @param hatch The hatch subsystem this command will run on
     */
    public MoveBall() {
      addCommands(new MoveBallToLocation1(), new MoveBallToLocation2(), new MoveBallToLocation3(),new MoveBallToLocation4());
    }
  
  }