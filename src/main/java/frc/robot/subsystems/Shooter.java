package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {

    private Spark flywheel;
    private Spark shooterGate;
    private DigitalInput shooterGateOpen;
    private DigitalInput shooterGateClosed;
    private Encoder flywheelEncoder;
    private Spark turntable;


    public Shooter() {
        flywheel = new Spark(RobotMap.SHOOTER_FLYWHEEL_SPARK);
        shooterGate = new Spark(RobotMap.SHOOTER_GATE_PWM);
        shooterGateOpen = new DigitalInput(RobotMap.SHOOTER_GATE_PROX);
        shooterGateClosed = new DigitalInput(9);
        flywheelEncoder = new Encoder(10, 11, false, EncodingType.k4X);
        turntable = new Spark(12);

        flywheel.setInverted(false);
        shooterGate.setInverted(false);
        flywheelEncoder.setDistancePerPulse(1.0);
        flywheelEncoder.setPIDSourceType(PIDSourceType.kRate);
        turntable.setInverted(false);


        addChild("Flywheel", flywheel);      
        addChild("ShooterGate", shooterGate);
        addChild("ShooterGateOpen", shooterGateOpen);
        addChild("ShooterGateClosed", shooterGateClosed);
        addChild("FlywheelEncoder", flywheelEncoder);
        addChild("Turntable", turntable);
        
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public boolean isShooterGateOpen(){
        return shooterGateOpen.get();
    }

    public boolean isShooterGateClosed(){
        return shooterGateClosed.get();
    }

    public boolean isShooterAtSpeed(){
        // TODO set speed variable w/ in subsystem
        return flywheel.getSpeed() == 1;
    }

    public void clockwiseTurntable(){
        turntable.set(0.5);
    }

    public void counterclockwiseTurntable(){
        turntable.set(-0.5);
    }

    public void spinFlywheel(){
        flywheel.set(1);
    }

    public void stopFlywheel(){
        flywheel.set(0);
    }

}
