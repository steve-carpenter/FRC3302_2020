package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Turret extends SubsystemBase {

    private Spark turret;

    public Turret() {
        turret = new Spark(RobotMap.SHOOTER_TURNTABLE_SPARK);
        turret.setInverted(false);
    }

    @Override
    public void periodic() {
    }

    public void moveTurret(double speed){
        turret.set(speed);
    }

    public void clockwiseTurntable(){
        turret.set(0.5);
    }

    public void counterclockwiseTurntable(){
        turret.set(-0.5);
    }

}

