package frc.robot.utils.motors;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.utils.motors.configurations.MotorConfiguration;

public class MotorSparkMax extends Motor {

    MotorConfiguration mc;
    CANSparkMax motor;
    
    public MotorSparkMax(MotorConfiguration motorConfiguration){
        mc = motorConfiguration;
        motor = new CANSparkMax(motorConfiguration.id, com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless);
        if(motorConfiguration.brake){
            motor.setIdleMode(IdleMode.kBrake);
        }else{
            motor.setIdleMode(IdleMode.kCoast);
        }

        motor.setOpenLoopRampRate(motorConfiguration.rampRate);

        if(mc.pid){
            motor.setClosedLoopRampRate(motorConfiguration.rampRate);
            motor.getPIDController().setP(motorConfiguration.kP);
            motor.getPIDController().setI(motorConfiguration.kI);
            motor.getPIDController().setD(motorConfiguration.kD);
            motor.getPIDController().setFF(motorConfiguration.kF);
            motor.getPIDController().setDFilter(motorConfiguration.kDFilt);
            motor.getPIDController().setOutputRange(-motorConfiguration.minPower, motorConfiguration.maxPower);
        }
        
        motor.setInverted(motorConfiguration.invert);
    }

    public void setPower(double power){
        if(power > 0) power *= mc.maxPower;
        else if(power < 0) power *= mc.minPower;
        motor.set(power);
    }

    public void setPosition(double position){
        motor.getPIDController().setReference(position, ControlType.kPosition);
    }

    public double getPosition(){
        return motor.getEncoder().getPosition();
    }
    
    public void setSpeed(double speed){
        motor.getPIDController().setReference(speed, ControlType.kVelocity);
    }
}