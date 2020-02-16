package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
        
        private double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0.0);
        private double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);
        private double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
        private double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0.0);
        private final int DRIVER_VIEW = 0;
        private final int TARGET_VIEW = 1;
        
    public Limelight() {
        enableDriverPipeline();
    }


    @Override
    public void periodic() {
        /*
        tv	Whether the limelight has any valid targets (0 or 1)
        tx	Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
        ty	Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)
        ta	Target Area (0% of image to 100% of image)
        */
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0.0);
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0.0);
    }

    public double getTV(){
        return tv;
    }

    public double getTX(){
        return tx;
    }

    public double getTY(){
        return ty;
    }

    public double getTA(){
        return ta;
    }

    public void enableDriverPipeline(){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(DRIVER_VIEW);
    }

    public void enableTargetPipeline(){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(TARGET_VIEW);
    }

}

