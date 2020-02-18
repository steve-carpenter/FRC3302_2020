package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.LatencyData;

public class RobotOdometry extends SubsystemBase {
 
    private final AHRS ahrs = new AHRS(SPI.Port.kMXP);
    private LatencyData xData = new LatencyData(20);
    private LatencyData yData = new LatencyData(20);
    private double baseLeftDistance;
    private double baseRightDistance;
    private Drive drive;
    private DifferentialDriveOdometry differentialDriveOdometry;

    public RobotOdometry(Drive drive){
      drive = this.drive;
      differentialDriveOdometry = new DifferentialDriveOdometry(getCurrentRotation());
    }

    @Override
    public void periodic() {
      Pose2d pose = updateOdometry();
      if (true) {
        // TODO : Print out X/Y/Degrees
        SmartDashboard.putNumber("Pose x", pose.getTranslation().getX());
        SmartDashboard.putNumber("Pose y", pose.getTranslation().getY());
        SmartDashboard.putNumber("Pose angle", pose.getRotation().getDegrees());
      }
    }
  
    private Pose2d updateOdometry() {
      Pose2d pose = differentialDriveOdometry.update(getCurrentRotation(), drive.getDistanceLeft() - baseLeftDistance,
          drive.getDistanceRight() - baseRightDistance);
      Translation2d translation = pose.getTranslation();
      xData.addDataPoint(translation.getX());
      yData.addDataPoint(translation.getY());
      return pose;
    }
  
    private Rotation2d getCurrentRotation() {
      return Rotation2d.fromDegrees(ahrs.getYaw() * -1);
    }
  
    private void resetBaseDistances() {
      baseLeftDistance = drive.getDistanceLeft();
      baseRightDistance = drive.getDistanceRight();
    }
  
    public Pose2d getCurrentPose() {
      return differentialDriveOdometry.getPoseMeters();
    }
  
    public void setPosition(double x, double y, Rotation2d angle) {
      setPosition(new Pose2d(x, y, angle));
    }
  

    public void setPosition(Pose2d position) {
      differentialDriveOdometry.resetPosition(position, getCurrentRotation());
      resetBaseDistances();
    }
  
    public void setPosition(Translation2d position, double timestamp) {
      setPosition(position.getX(), position.getY(), timestamp);
    }
  
    public void setPosition(double x, double y, double timestamp) {
      updateOdometry();
      xData.addCorrectedData(x, timestamp);
      yData.addCorrectedData(y, timestamp);
      differentialDriveOdometry.resetPosition(
          new Pose2d(xData.getCurrentPoint(), yData.getCurrentPoint(), getCurrentPose().getRotation()),
          getCurrentRotation());
      resetBaseDistances();
    }
  
    public void setX(double x, double timestamp) {
      updateOdometry();
      xData.addCorrectedData(x, timestamp);
      differentialDriveOdometry.resetPosition(
          new Pose2d(xData.getCurrentPoint(), getCurrentPose().getTranslation().getY(), getCurrentPose().getRotation()),
          getCurrentRotation());
      resetBaseDistances();
    }
  
    public void setY(double y, double timestamp) {
      updateOdometry();
      yData.addCorrectedData(y, timestamp);
      differentialDriveOdometry.resetPosition(
          new Pose2d(getCurrentPose().getTranslation().getX(), yData.getCurrentPoint(), getCurrentPose().getRotation()),
          getCurrentRotation());
      resetBaseDistances();
    }
  
    public void setRotation(Rotation2d rotation) {
      updateOdometry();
      Translation2d currentTranslation = getCurrentPose().getTranslation();
      differentialDriveOdometry.resetPosition(new Pose2d(currentTranslation, rotation), getCurrentRotation());
      resetBaseDistances();
    }
    
}