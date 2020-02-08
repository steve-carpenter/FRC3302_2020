package frc.robot.utils.motors;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.utils.motors.configurations.MotorConfiguration;

public class MotorSpark extends Motor {

    MotorConfiguration mc;
    Spark spark;

    public MotorSpark(MotorConfiguration motorConfiguration) {
            mc = motorConfiguration;
            spark = new Spark(motorConfiguration.id);
    
            if(motorConfiguration.pid){
                // TODO what goes here?
                spark.pidWrite(0.0);
            }
            
            spark.setInverted(mc.invert);
        }
    
        public void setPower(double power){
            if(power > 0) power *= mc.maxPower;
            else if(power < 0) power *= mc.minPower;
            spark.set(power);
        }
    
        public void setPosition(double position){
            // TODO is this possible?
        }
    
        public double getPosition(){
            // TODO is this possible?
            return 0.0;
        }
        
        public void setSpeed(double speed){
            spark.set(speed);
        }    
    }