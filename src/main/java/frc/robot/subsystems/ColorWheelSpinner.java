package frc.robot.subsystems;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.colorwheel.SpinToColor.SpinnerColor;

public class ColorWheelSpinner extends SubsystemBase {

    private CANSparkMax m_colorWheel;
    private ColorMatch colorMatcher = new ColorMatch();
    private ColorMatchResult colorMatchResult;
    private CANEncoder m_colorWheelEncoder; 
    private CANPIDController m_colorWheelPidController;
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
    private final double kColorWheelWedgeSize = 12.5;
    private final double kColorWheelCircumference = 100;
    private final double kWheelSize = 4;
    private static final AlternateEncoderType kAltEncType = AlternateEncoderType.kQuadrature;
    private static final int kCPR = 8192;
    private SendableChooser<Command> chooser = new SendableChooser<Command>();

    public ColorWheelSpinner() {
        colorMatcher.addColorMatch(kBlueTarget);
        colorMatcher.addColorMatch(kGreenTarget);
        colorMatcher.addColorMatch(kRedTarget);
        colorMatcher.addColorMatch(kYellowTarget);
        m_colorWheel = new CANSparkMax(14,MotorType.kBrushed);
        m_colorWheelEncoder = m_colorWheel.getEncoder();
        m_colorWheelPidController = m_colorWheel.getPIDController();
        m_colorWheelPidController.setFeedbackDevice(m_colorWheel.getAlternateEncoder(kAltEncType, kCPR));
    }

    @Override
    public void periodic() {
        Color detectedColor = m_colorSensor.getColor();
        colorMatchResult = colorMatcher.matchClosestColor(detectedColor);
        printColorValues();
    }

    public ColorMatchResult getColorMatchResult(){
        return colorMatchResult;
    }

    public void spinColorWheel(){
        m_colorWheel.set(0.5);
    }

    public void stopColorWheel(){
        m_colorWheel.set(0);
    }

    public void spinXTimes(int x){

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

    private void printColorValues(){
        SmartDashboard.putBoolean("isRed", isRed());
        SmartDashboard.putBoolean("isBlue", isBlue());
        SmartDashboard.putBoolean("isGreen", isGreen());
        SmartDashboard.putBoolean("isYellow", isYellow());
    }

    public double getColorWheelPieSize(){
        return kColorWheelWedgeSize;
    }

    public double getWheelSize(){
        return kWheelSize;
    }

    public void spinNumberOfTimes(double spins){
        m_colorWheelPidController.setReference(spinsToRotations(spins), ControlType.kPosition);
    }

    public CANEncoder getEncoder(){
        return m_colorWheelEncoder;
    }

    private double spinsToRotations(double spins){
        return (spins * kColorWheelCircumference) / kWheelSize;
    }

    private void smartDashboardSetup(){

    }


}
