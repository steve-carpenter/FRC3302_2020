package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LowGoalGate extends SubsystemBase {

private Spark gate;
private DigitalInput gateOpen;
private DigitalInput gateClosed;

    public LowGoalGate() {
gate = new Spark(10);
addChild("Gate",gate);
gate.setInverted(false);
        
gateOpen = new DigitalInput(6);
addChild("GateOpen",gateOpen);

        
gateClosed = new DigitalInput(7);
addChild("GateClosed",gateClosed);

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

    public boolean isGateOpen(){
        return gateOpen.get();
    }

    public boolean isGateClosed(){
        return gateClosed.get();
    }

}

