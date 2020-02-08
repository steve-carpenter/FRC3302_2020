package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.utils.motors.Motor;
import frc.robot.utils.motors.configurations.FlywheelMotorConfiguration;
import frc.robot.utils.motors.configurations.MotorConfiguration;

public class Shooter extends SubsystemBase {

    private Motor flywheel;
    private FlywheelMotorConfiguration flywheelMotorConfiguration;
    private Spark shooterGate;
    private DigitalInput shooterGateOpen;
    private DigitalInput shooterGateClosed;
    private Encoder flywheelEncoder;


    public Shooter(FlywheelMotorConfiguration config) {
        this.flywheelMotorConfiguration = config;
        if(config.disabled) return;
        flywheel = Motor.initMotor(config.motor);

        shooterGate = new Spark(RobotMap.SHOOTER_GATE_PWM);
        shooterGateOpen = new DigitalInput(RobotMap.SHOOTER_GATE_PROX);
        shooterGateClosed = new DigitalInput(9);
        shooterGate.setInverted(false);
     
        addChild("ShooterGate", shooterGate);
        addChild("ShooterGateOpen", shooterGateOpen);
        addChild("ShooterGateClosed", shooterGateClosed);
        addChild("FlywheelEncoder", flywheelEncoder);        
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

    public void setFlywheelSpeed(double speed){
        flywheel.setSpeed(speed);
    }

    public double distanceToSpeed(double distance){
        return distance * 0.75;
    }

}
