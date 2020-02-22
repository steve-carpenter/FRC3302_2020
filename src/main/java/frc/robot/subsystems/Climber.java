package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("climberExtended", isClimberExtended());
        SmartDashboard.putBoolean("climberRetracted", isClimberRetracted());
    }

    public void extendClimber(){
        if(!isClimberExtended()){
            setPower(1);
        }
        else{
            stopClimber();
        }
    }

    public void retractClimber(){
        if(!isClimberRetracted()){
            setPower(-1);
        }
        else{
            stopClimber();
        }
    }

    public void stopClimber(){
        setPower(0);
    }

    public boolean isClimberExtended(){
        return climberExtended.get();
    }

    public boolean isClimberRetracted(){
        return climberRetracted.get();
    }

    public void setPower(double speed){
        winch.set(speed);
    }

}

