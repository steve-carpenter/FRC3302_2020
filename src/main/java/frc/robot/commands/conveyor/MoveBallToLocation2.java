// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.commands.conveyor;

import frc.robot.RobotContainer;

/**
 *
 */
public class MoveBallToLocation2 extends MoveBallToLocation {

    public MoveBallToLocation2(RobotContainer subsystem) {
        super(subsystem);
    }

    @Override
    protected void runConveyor() {
        // getSubSystem().m_conveyor.runBottomConveyor();

    }

    @Override
    protected void stopConveyor() {
        // getSubSystem().m_conveyor.stopBottomConveyor();

    }

    @Override
    protected boolean isBallPresent() {
        return getSubSystem().m_conveyor.isBall2Present();
    }

    @Override
    protected boolean canIndex() {
        return !getSubSystem().m_conveyor.isBall3Present();
    }

    @Override
    protected String getConveyorId() {
        return "LOCATION 2";
    }
   
    
}
