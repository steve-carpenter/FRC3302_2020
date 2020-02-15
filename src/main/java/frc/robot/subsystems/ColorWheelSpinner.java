package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorWheelSpinner extends SubsystemBase {

    private ColorSensorV3 colorSensor;
    private Spark colorWheel;
    private ColorMatch colorMatcher;
    private ColorMatchResult colorMatchResult;
    private final I2C.Port i2cPort = I2C.Port.kOnboard;

    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public ColorWheelSpinner() {
        colorSensor = new ColorSensorV3(i2cPort);
        colorWheel = new Spark(14);
    }

    @Override
    public void periodic() {
        //colorMatchResult = colorMatcher.matchClosestColor(colorSensor.getColor());
    }

    public ColorMatchResult getColorMatchResult(){
        return colorMatchResult;
    }

    public void spinColorWheel(){
        colorWheel.set(0.5);
    }

    public void stopColorWheel(){
        colorWheel.set(0);
    }

    public boolean isBlue(){
        return colorMatchResult.color == kBlueTarget;
    }

    public boolean isRed(){
        return colorMatchResult.color == kRedTarget;
    }

    public boolean isGreen(){
        return colorMatchResult.color == kGreenTarget;
    }

    public boolean isYellow(){
        return colorMatchResult.color == kYellowTarget;
    }
}
