package frc.robot.utils.motors.configurations;

public class MotorConfiguration {
    public MotorType type;
    public int id;
    public double minPower;
    public double maxPower;
    public boolean pid = false;
    public double kP;
    public double kI;
    public double kD;
    public double kDFilt;
    public double kF;
    public double rampRate;
    public boolean brake;
    public boolean invert = false;

    public enum MotorType{
        SPARK_MAX, SPARK
    }

    public static MotorConfiguration sparkmax(int id){
        return new MotorConfiguration(MotorType.SPARK_MAX, id);
    }

    public static MotorConfiguration spark(int id){
        return new MotorConfiguration(MotorType.SPARK, id);
    }

    MotorConfiguration(MotorType type, int id, double kP, double kI, double kD){

    }
    
    MotorConfiguration(MotorType type, int id, double powerLim){
        this.type = type;
        this.id = id;
        this.maxPower = powerLim;
        this.minPower = -powerLim;
    }

    MotorConfiguration(MotorType type, int id){
        this(type, id, 1);  
    }   

    public MotorConfiguration pid(double p, double i, double d, double f){
        pid = true;
        kP = p;
        kI = i;
        kD = d;
        kF = f;
        return this;
    }

    public MotorConfiguration brake(){
        this.brake = true;
        return this;
    }

    public MotorConfiguration invert(){
        this.invert = true;
        return this;
    }

    public MotorConfiguration coast(){
        brake = false;
        return this;
    }

    public MotorConfiguration limit(double min, double max){
        minPower = min;
        maxPower = max;
        return this;
    }

    public MotorConfiguration dFilt(double filter){
        kDFilt = filter;
        return this;
    }

    public MotorConfiguration ramp(double rate){
        rampRate = rate;
        return this;
    }

}