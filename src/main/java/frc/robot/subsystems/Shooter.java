package frc.robot.subsystems;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.utils.TunableNumber;

public class Shooter extends SubsystemBase {

    private CANSparkMax flywheel;
    private CANEncoder flywheelEncoder;
    private CANPIDController flywheelPIDController;
    private static final AlternateEncoderType kAltEncType = AlternateEncoderType.kQuadrature;
    private static final int kCPR = 8192;
    private Spark shooterGate;
    private DigitalInput shooterGateOpen;
    private DigitalInput shooterGateClosed;
    private TunableNumber P = new TunableNumber("Shooter PID (P)", 0.0012);
    private TunableNumber I = new TunableNumber("Shooter PID (I)", 0);
    private TunableNumber D = new TunableNumber("Shooter PID (D)", 0);
    private TunableNumber F = new TunableNumber("Shooter PID (F)", 0.00019068);
    private TunableNumber rampRate = new TunableNumber("Shooter (Ramp Rate)", 2);
    private TunableNumber maxOutput = new TunableNumber("Shooter (Max Output)", 1);
    private TunableNumber minOutput = new TunableNumber("Shooter (Min Output)", -1);
    public double kP, kI, kD, kFF, kMaxOutput, kMinOutput, maxRPM;
    private Double lastRampRate = null; // Force this to be updated once
    private static final double MULTIPLIER = 1.5;


    public Shooter(){
        flywheel = new CANSparkMax(RobotMap.SHOOTER_FLYWHEEL_SPARK, MotorType.kBrushless);
        flywheelPIDController = flywheel.getPIDController();
        // shooterGate = new Spark(RobotMap.SHOOTER_GATE_PWM);
        // shooterGate.setInverted(false);

        flywheelPIDController.setP(kP);
        flywheelPIDController.setI(kI);
        flywheelPIDController.setD(kD);
        flywheelPIDController.setFF(kFF);
        flywheelPIDController.setOutputRange(kMinOutput, kMaxOutput);
        flywheelPIDController.setFeedbackDevice(flywheel.getAlternateEncoder(kAltEncType, kCPR));
         
        addChild("ShooterGate", shooterGate);
        addChild("ShooterGateOpen", shooterGateOpen);
        addChild("ShooterGateClosed", shooterGateClosed);  
    }

    @Override
    public void periodic() {
    double p = P.get();
    double i = I.get();
    double d = D.get();
    double ff = F.get();
    double max = maxOutput.get();
    double min = minOutput.get();

    if ((p != kP)) {
      flywheelPIDController.setP(p);
      kP = p;
    }
    if ((i != kI)) {
        flywheelPIDController.setI(i);
      kI = i;
    }
    if ((d != kD)) {
        flywheelPIDController.setD(d);
      kD = d;
    }
    if ((ff != kFF)) {
        flywheelPIDController.setFF(ff);
      kFF = ff;
    }
    if ((max != kMaxOutput) || (min != kMinOutput)) {
      flywheelPIDController.setOutputRange(min, max);
      kMinOutput = min;
      kMaxOutput = max;
    }
  }

    // public boolean isShooterGateOpen(){
    //     return shooterGateOpen.get();
    // }

    // public boolean isShooterGateClosed(){
    //     return shooterGateClosed.get();
    // }

    public void setFlywheelSpeed(double setpoint){
        flywheelPIDController.setReference(setpoint, ControlType.kVelocity);
    }

    public double distanceToSpeed(double distance){
        return distance * 0.75;
    }

    public double getSpeed() {
      if (flywheel == null) {
        return 0;
      }
     return flywheelEncoder.getVelocity();
    }

      public void stop() {
        if (flywheel == null) {
          return;
        }
        flywheel.stopMotor();
      }
    
      public void setShooterRPM(double rpm) {
        if (flywheel == null) {
          return;
        }
        double setpoint = rpm / MULTIPLIER;
        flywheelPIDController.setReference(setpoint, ControlType.kVelocity);
      }
    
      public void run(double power) {
        if (flywheel == null) {
          return;
        }
        flywheel.set(power);
      }

      // public void openShooterGate(){
      //   shooterGate.set(0.5);
      // }

      // public void closeShooterGate(){
      //   shooterGate.set(-0.5);
      // }

      // public void stopShooterGate(){
      //   shooterGate.set(0);
      // }
}
