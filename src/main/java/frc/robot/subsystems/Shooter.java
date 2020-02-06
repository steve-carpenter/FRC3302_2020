package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private Spark flywheel;
    private Spark shooterGate;
    private DigitalInput shooterGateOpen;
    private DigitalInput shooterGateClosed;
    private Encoder flywheelEncoder;
    private Spark turntable;


    public Shooter() {
        flywheel = new Spark(4);
        addChild("Flywheel", flywheel);
        flywheel.setInverted(false);

        shooterGate = new Spark(11);
        addChild("ShooterGate", shooterGate);
        shooterGate.setInverted(false);

        shooterGateOpen = new DigitalInput(8);
        addChild("ShooterGateOpen", shooterGateOpen);

        shooterGateClosed = new DigitalInput(9);
        addChild("ShooterGateClosed", shooterGateClosed);

        flywheelEncoder = new Encoder(10, 11, false, EncodingType.k4X);
        addChild("FlywheelEncoder", flywheelEncoder);
        flywheelEncoder.setDistancePerPulse(1.0);
        flywheelEncoder.setPIDSourceType(PIDSourceType.kRate);

        turntable = new Spark(12);
        addChild("Turntable", turntable);
        turntable.setInverted(false);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

}
