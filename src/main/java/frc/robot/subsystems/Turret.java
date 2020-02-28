package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.enums.TurretSearchState;

public class Turret extends SubsystemBase {

    private Spark turret;
    private DigitalInput panLeftStop;
    private DigitalInput panRightStop;
    private TurretSearchState m_turretSearchState;

    public Turret() {
        // turret = new Spark(RobotMap.SHOOTER_TURNTABLE_SPARK);
        panLeftStop = new DigitalInput(RobotMap.TURRENT_LEFT_MAX);
        panRightStop = new DigitalInput(RobotMap.TURRET_RIGHT_MAX);
        turret.setInverted(false);
        m_turretSearchState = TurretSearchState.PAN_RIGHT;
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("isPanLeftDone", isPanLeftDone());
        SmartDashboard.putBoolean("isPanRightDone", isPanRightDone());
    }

    public void moveTurret(double speed){
        turret.set(speed);
    }

    public void rotateLeft(){
        if(!isPanLeftDone()){
            turret.set(0.5);
        }
        else{
            turret.set(0);
        }       
    }

    public void rotateRight(){
        if(!isPanRightDone()){
            turret.set(-0.5);
        }
        else{
            turret.set(0);
        }
        
    }

    public boolean isPanLeftDone(){
        return panLeftStop.get();
    }

    public boolean isPanRightDone(){
        return panRightStop.get();
    }

    public void searchMode(){
        switch(m_turretSearchState){
            case PAN_RIGHT:{
                if(isPanRightDone()){
                    m_turretSearchState.next();
                }
                else{
                    rotateRight();
                }
            }
            case PAN_LEFT:{
                if(isPanLeftDone()){
                    m_turretSearchState.next();
                }
                else{
                    rotateLeft();
                }
            }
        }
    }





}

