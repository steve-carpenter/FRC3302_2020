/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Spark Controllers
	public static final int DRIVETRAIN_LEFT_FRONT_SPARK = 0;
	public static final int DRIVETRAIN_LEFT_BACK_SPARK = 1;
	public static final int DRIVETRAIN_RIGHT_FRONT_SPARK = 2;
    public static final int DRIVETRAIN_RIGHT_BACK_SPARK = 3;
    public static final int CONVEYOR_BOTTOM_ROLLER_SPARK = 4;
    public static final int CONVEYOR_TOP_ROLLER_SPARK = 5;
    public static final int INTAKE_FRONT_ROLLER_SPARK = 6;
    public static final int INTAKE_REAR_ROLLER_SPARK = 7;
    public static final int SHOOTER_FLYWHEEL_SPARK = 8;
    public static final int SHOOTER_TURNTABLE_SPARK = 9;
    public static final int CLIMBER_WINCH_SPARK = 10;
    public static final int LOW_GOAL_GATE_SPARK = 11;
    public static final int BLINKIN_SPARK = 12;


    //PWM
    public static final int SHOOTER_GATE_PWM = 1;


	// Joystick
	public static final int OI_DRIVER_CONTROLLER = 0;
	public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1;
	public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 2;

	// Sensors
    public static final int CONVEYOR_BALL_1_PRESENT = 0;
    public static final int CONVEYOR_BALL_2_PRESENT = 1;
    public static final int CONVEYOR_BALL_3_PRESENT = 2;
    public static final int CONVEYOR_BALL_4_PRESENT = 3;
    public static final int SHOOTER_GATE_PROX = 4;
    public static final int CLIMBER_EXTENDED_PROX = 5;
    public static final int CLIMBER_RETRACTED_PROX = 6;
    public static final int LOW_GOAL_GATE_PROX = 7;

    // Speed
    public static final int INTAKE_COLLECT_SPEED = 100;
    public static final int INTAKE_EJECT_SPEED = -100;
	

}