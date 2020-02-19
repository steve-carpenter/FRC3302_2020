package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.utils.TunableNumber;
import frc.robot.utils.motors.Motor;
import frc.robot.utils.motors.configurations.FlywheelMotorConfiguration;
import frc.robot.utils.motors.configurations.MotorConfiguration;

public class Shooter extends SubsystemBase {

    private CANSparkMax flywheel;
    private CANEncoder flywheelEncoder;
    private CANPIDController flywheelPIDController;
    private Spark shooterGate;
    private DigitalInput shooterGateOpen;
    private DigitalInput shooterGateClosed;
    private TunableNumber P = new TunableNumber("Shooter PID (P)");
    private TunableNumber I = new TunableNumber("Shooter PID (I)");
    private TunableNumber D = new TunableNumber("Shooter PID (D)");
    private TunableNumber F = new TunableNumber("Shooter PID (F)");
    private TunableNumber rampRate = new TunableNumber("Shooter (Ramp Rate)");
    private TunableNumber maxOutput = new TunableNumber("Shooter (Max Output)");
    private TunableNumber minOutput = new TunableNumber("Shooter (Min Output)");



    public Shooter(FlywheelMotorConfiguration config) {
        // this.flywheelMotorConfiguration = config;
        // if(config.disabled) return;
        // flywheel = Motor.initMotor(config.motor);

        shooterGate = new Spark(RobotMap.SHOOTER_GATE_PWM);
        shooterGateOpen = new DigitalInput(RobotMap.SHOOTER_GATE_PROX);
        shooterGateClosed = new DigitalInput(9);
        shooterGate.setInverted(false);
     
        addChild("ShooterGate", shooterGate);
        addChild("ShooterGateOpen", shooterGateOpen);
        addChild("ShooterGateClosed", shooterGateClosed);       
    }

    public Shooter(){
        flywheel = new CANSparkMax(RobotMap.SHOOTER_FLYWHEEL_SPARK,MotorType.kBrushless);
        flywheelEncoder = flywheel.getEncoder();
        flywheelPIDController = flywheel.getPIDController();
        shooterGate = new Spark(RobotMap.SHOOTER_GATE_PWM);
        shooterGateOpen = new DigitalInput(RobotMap.SHOOTER_GATE_PROX);
        shooterGateClosed = new DigitalInput(9);
        shooterGate.setInverted(false);
    
        P.setDefault(0.0012);
        I.setDefault(0);
        D.setDefault(0);
        F.setDefault(0.00019068);
        rampRate.setDefault(2);
        maxOutput.setDefault(1);
        minOutput.setDefault(-1);
     
        addChild("ShooterGate", shooterGate);
        addChild("ShooterGateOpen", shooterGateOpen);
        addChild("ShooterGateClosed", shooterGateClosed);  
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

    public void setFlywheelSpeed(double setpoint){
        flywheelPIDController.setReference(setpoint, ControlType.kVelocity);
    }

    public double distanceToSpeed(double distance){
        return distance * 0.75;
    }

}
