package frc.robot.commands.conveyor;
import frc.robot.Robot;

public class MoveBallToLocation4 extends MoveBallToLocation {

    @Override
    protected void runConveyor() {
        Robot.conveyor.runTopConveyor();

    }

    @Override
    protected void stopConveyor() {
       Robot.conveyor.stopTopConveyor();

    }

    @Override
    protected boolean isBallPresent() {
        return Robot.conveyor.isBall3Present();
    }

    
    
}
