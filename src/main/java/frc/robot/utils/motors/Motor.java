package frc.robot.utils.motors;

import frc.robot.utils.motors.configurations.MotorConfiguration;

public abstract class Motor {
    public static Motor initMotor(MotorConfiguration mc){
        switch(mc.type){
            case SPARK:
                return new MotorSpark(mc);

            case SPARK_MAX:
                return new MotorSparkMax(mc);

            default:
                return null;
        }
    }

    public abstract void setPower(double power);
    public abstract void setPosition(double position);
    public abstract double getPosition();
    public abstract void setSpeed(double speed);
}