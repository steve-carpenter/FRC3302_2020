package frc.robot.utils.motors.configurations;

import frc.robot.RobotMap;
import frc.robot.utils.motors.configurations.MotorConfiguration.MotorType;

public class FlywheelMotorConfiguration {
    public boolean disabled = false;
    public MotorConfiguration motor = new MotorConfiguration(MotorType.SPARK_MAX, RobotMap.SHOOTER_FLYWHEEL_SPARK);
}