package frc.robot.commands.conveyor;
import frc.robot.Robot;

public class MoveBallToLocation3 extends MoveBallToLocation {

    @Override
    protected void runConveyor() {
        Robot.conveyor.runBottomConveyor();

    }

    @Override
    protected void stopConveyor() {
       Robot.conveyor.stopBottomConveyor();

    }

    @Override
    protected boolean isBallPresent() {
        return Robot.conveyor.isBall1Present();
    }

    
    
}
