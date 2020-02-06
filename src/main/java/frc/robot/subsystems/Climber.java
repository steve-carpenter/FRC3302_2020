package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase {

private Spark winch;
private DigitalInput climberExtended;
private DigitalInput climberRetracted;

    public Climber() {
winch = new Spark(RobotMap.CLIMBER_WINCH_SPARK);
climberExtended = new DigitalInput(RobotMap.CLIMBER_EXTENDED_PROX);
climberRetracted = new DigitalInput(RobotMap.CLIMBER_RETRACTED_PROX);

winch.setInverted(false);

addChild("Winch",winch);
addChild("ClimberExtended",climberExtended);
addChild("ClimberRetracted",climberRetracted);
    }


    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void extendClimber(){
        winch.set(1);
    }

    public void retractClimber(){
        winch.set(-1);
    }

    public void stopClimber(){
        winch.set(0);
    }

    public boolean isClimberExtended(){
        return climberExtended.get();
    }

    public boolean isClimberRetracted(){
        return climberRetracted.get();
    }

}

