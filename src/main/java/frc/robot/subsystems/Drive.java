// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Drive extends SubsystemBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private CANSparkMax leftFront;
    private CANSparkMax leftRear;
    private CANSparkMax rightFront;
    private CANSparkMax rightRear;
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;
    private DifferentialDrive chassis;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftFront = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_FRONT_SPARK, MotorType.kBrushless);
        leftRear = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_BACK_SPARK, MotorType.kBrushless);
        rightFront = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_FRONT_SPARK,MotorType.kBrushless);
        rightRear = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_BACK_SPARK, MotorType.kBrushless);

        leftSide = new SpeedControllerGroup(leftFront, leftRear);
        rightSide = new SpeedControllerGroup(rightFront, rightRear);

        chassis = new DifferentialDrive(leftSide, rightSide);

        leftFront.setInverted(false);
        leftRear.setInverted(false);
        rightFront.setInverted(false);
        rightRear.setInverted(false);

        chassis.setSafetyEnabled(true);
        chassis.setExpiration(0.1);
        chassis.setMaxOutput(1.0);

        // addChild("LeftFront", leftFront);
        // addChild("LeftRear", leftRear);
        // addChild("RightFront", rightFront);
        // addChild("RightRear", rightRear);
    }

    @Override
    public void periodic() {
    }

    public void arcadeDrive(double moveSpeed, double rotateSpeed) {
        chassis.arcadeDrive(moveSpeed, rotateSpeed);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        System.out.println("tank drive " + leftSpeed + "------" + rightSpeed);
        chassis.tankDrive(leftSpeed, rightSpeed);
    }

}
