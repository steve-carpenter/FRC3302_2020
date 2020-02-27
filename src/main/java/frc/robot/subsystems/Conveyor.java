package frc.robot.subsystems;


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Conveyor extends SubsystemBase {

private Spark bottomConveyor;
private Spark bottomConveyor2;
private Spark topConveyor;
private Spark topConveyor2;
private DigitalInput ballLocation1;
private DigitalInput ballLocation2;
private DigitalInput ballLocation3;
private DigitalInput ballLocation4;


    public Conveyor() {
bottomConveyor = new Spark(RobotMap.CONVEYOR_BOTTOM_ROLLER_SPARK);
bottomConveyor2 = new Spark(RobotMap.CONVEYOR_BOTTOM_ROLLER_SPARK2);
topConveyor = new Spark(RobotMap.CONVEYOR_TOP_ROLLER_SPARK);
topConveyor2 = new Spark(RobotMap.CONVEYOR_TOP_ROLLER_SPARK2);
ballLocation1 = new DigitalInput(RobotMap.CONVEYOR_BALL_1_PRESENT);
ballLocation2 = new DigitalInput(RobotMap.CONVEYOR_BALL_2_PRESENT);
ballLocation3 = new DigitalInput(RobotMap.CONVEYOR_BALL_3_PRESENT);
ballLocation4 = new DigitalInput(RobotMap.CONVEYOR_BALL_4_PRESENT);

bottomConveyor.setInverted(false);
topConveyor.setInverted(false);       

addChild("BottomConveyor",bottomConveyor);
addChild("TopConveyor",topConveyor);
addChild("BallLocation1",ballLocation1);
addChild("BallLocation2",ballLocation2);
addChild("BallLocation3",ballLocation3);
addChild("BallLocation4",ballLocation4);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void runTopConveyor(){
        topConveyor(1);
    }

    public void stopTopConveyor(){
        topConveyor(0);
    }

    public void stopBottomConveyor(){
        bottomConveyor(0);
    }

    public void runBottomConveyor(){
        bottomConveyor(1);
    }

    public void topConveyor(int speed){
        topConveyor.set(speed);
        topConveyor2.set(speed);
    }

    public void bottomConveyor(int speed){
        bottomConveyor.set(speed);
        bottomConveyor2.set(speed);
    }

    public boolean isBall1Present(){
        return !ballLocation1.get();
    }

    public boolean isBall2Present(){
        return !ballLocation1.get();
    }

    public boolean isBall3Present(){
        return !ballLocation1.get();
    }

    public boolean isBall4Present(){
        return !ballLocation1.get();
    }

    public boolean isConveyorEmpty(){
        return (!isBall1Present() && !isBall2Present() && !isBall3Present() && !isBall4Present());
    }

    public void runConveyors(){
        runTopConveyor();
        runBottomConveyor();
    }

    public void stopConveyors(){
        stopTopConveyor();
        stopBottomConveyor();
    }

}

