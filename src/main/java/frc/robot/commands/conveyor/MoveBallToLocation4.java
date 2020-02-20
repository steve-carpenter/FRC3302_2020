package frc.robot.commands.conveyor;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveBallToLocation4 extends MoveBallToLocation {

    public MoveBallToLocation4(RobotContainer subsystem) {
        super(subsystem);
    }

    @Override
    protected void runConveyor() {
        getSubSystem().m_conveyor.runTopConveyor();

    }

    @Override
    protected void stopConveyor() {
        getSubSystem().m_conveyor.stopTopConveyor();

    }

    @Override
    protected boolean isBallPresent() {
        return getSubSystem().m_conveyor.isBall3Present();
    }

	@Override
	protected boolean canIndex() {
		return false;
    }

    @Override
    protected String getConveyorId() {
        return "LOCATION 4";
    }    
}
