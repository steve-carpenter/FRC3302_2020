package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoAlignSpeed extends SequentialCommandGroup {

    public AutoAlignSpeed() {
        parallel(new AutoAlign(), new AutoSpeed());
    }

    public boolean isFinished() {
        return false;
        
    }
  
  }