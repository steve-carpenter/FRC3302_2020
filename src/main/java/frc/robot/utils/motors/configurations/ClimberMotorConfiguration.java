package frc.robot.utils.motors.configurations;

import frc.robot.RobotMap;
import frc.robot.utils.motors.configurations.MotorConfiguration.MotorType;

public class ClimberMotorConfiguration {
    public boolean disabled = false;
    public MotorConfiguration winch = new MotorConfiguration(MotorType.SPARK_MAX, RobotMap.CLIMBER_WINCH_SPARK);
    public static double forwardPower = 0.5;
    public static double backwardPower = -0.5;
}