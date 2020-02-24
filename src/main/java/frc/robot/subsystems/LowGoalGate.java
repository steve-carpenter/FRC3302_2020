package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LowGoalGate extends SubsystemBase {

private Spark gate;

    public LowGoalGate() {
gate = new Spark(19);
addChild("Gate",gate);
gate.setInverted(false);

    }

    @Override
    public void periodic() {

    }

    public void closeGate(){
        gate.set(-1);
    }

    public void openGate(){
        gate.set(1);
    }

    public void stopGate(){
        gate.set(0);
    }

}

