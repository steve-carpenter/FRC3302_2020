
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class SpinToColor extends CommandBase {

    public enum SpinnerColor{
        BLUE,
        RED,
        GREEN,
        YELLOW
    }

    private SpinnerColor color;

    public SpinToColor(SpinnerColor color) {
        addRequirements(Robot.colorWheelSpinner);
        color = this.color;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        switch(color){
            case RED:{
                if(!Robot.colorWheelSpinner.isRed()){
                    Robot.colorWheelSpinner.spinColorWheel();
                }
                else{
                    end(false);
                }
            }
            case GREEN:{
                if(!Robot.colorWheelSpinner.isGreen()){
                    Robot.colorWheelSpinner.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            case BLUE:{
                if(!Robot.colorWheelSpinner.isBlue()){
                    Robot.colorWheelSpinner.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            case YELLOW:{
                if(!Robot.colorWheelSpinner.isYellow()){
                    Robot.colorWheelSpinner.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            System.out.println("Trying to match color: "+ color);
        }

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.colorWheelSpinner.stopColorWheel();
    }

}
