package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.utils.motors.Motor;
import frc.robot.utils.motors.configurations.ClimberMotorConfiguration;

public class Climber extends SubsystemBase {

private Motor winch;
private ClimberMotorConfiguration climberMotorConfiguration;
private DigitalInput climberExtended;
private DigitalInput climberRetracted;

    public Climber(ClimberMotorConfiguration config) {
        this.climberMotorConfiguration = config;
        if(config.disabled) return;
        winch = Motor.initMotor(config.motor);
        climberExtended = new DigitalInput(RobotMap.CLIMBER_EXTENDED_PROX);
        climberRetracted = new DigitalInput(RobotMap.CLIMBER_RETRACTED_PROX);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void extendClimber(){
        winch.setPower(1);;
    }

    public void retractClimber(){
        winch.setPower(-1);
    }

    public void stopClimber(){
        winch.setPower(0);
    }

    public boolean isClimberExtended(){
        return climberExtended.get();
    }

    public boolean isClimberRetracted(){
        return climberRetracted.get();
    }

    public void setPower(double power){
        if(climberMotorConfiguration.disabled) return;
        winch.setPower(power);
    }
    public void setSpeed(double speed){
        if(climberMotorConfiguration.disabled) return;
        winch.setSpeed(speed);
    }

}

