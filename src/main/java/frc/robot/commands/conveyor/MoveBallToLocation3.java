package frc.robot.commands.conveyor;

import frc.robot.RobotContainer;

public class MoveBallToLocation3 extends MoveBallToLocation {

    public MoveBallToLocation3(RobotContainer subsystem) {
        super(subsystem);
    }

    @Override
    protected void runConveyor() {
        getSubSystem().m_conveyor.runBottomConveyor();

    }

    @Override
    protected void stopConveyor() {
        getSubSystem().m_conveyor.stopBottomConveyor();

    }

    @Override
    protected boolean isBallPresent() {
        return getSubSystem().m_conveyor.isBall3Present();
    }

    @Override
    protected boolean canIndex() {
       return !getSubSystem().m_conveyor.isBall4Present();
    }

    
    
}
