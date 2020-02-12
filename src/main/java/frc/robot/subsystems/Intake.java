package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {

private Spark frontIntake;
private Spark rearIntake;


    public Intake() {
frontIntake = new Spark(RobotMap.INTAKE_FRONT_ROLLER_SPARK);
rearIntake = new Spark(RobotMap.INTAKE_REAR_ROLLER_SPARK);

frontIntake.setInverted(false);
rearIntake.setInverted(false);

addChild("FrontIntake",frontIntake);
addChild("RearIntake",rearIntake);

    }

    @Override
    public void periodic() {
    }

    public void intakeFront(double speed){
        frontIntake.set(speed);
    }

    public void intakeRear(double speed){
        rearIntake.set(speed);
    }

}

