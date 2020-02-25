
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSpinner;

public class SpinToColor extends CommandBase {
    private ColorWheelSpinner m_subsystem;
    private SpinnerColor m_color;
    private boolean m_isOffset;

    public enum SpinnerColor{
        BLUE,
        RED,
        GREEN,
        YELLOW
    }

    public SpinToColor(ColorWheelSpinner subsystem, SpinnerColor color) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
        color = this.m_color;
        m_isOffset = m_subsystem.hasColorWheelOffset();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        spinToColor(m_isOffset);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.stopColorWheel();
    }

    private void spinToColor(boolean withOffset){
        if(withOffset){
            m_color = offsetColor(m_color);
        }
        switch(m_color){
            case RED:{
                if(!m_subsystem.isRed()){
                    m_subsystem.spinColorWheel();
                }
                else{
                    end(false);
                }
            }
            case GREEN:{
                if(!m_subsystem.isGreen()){
                    m_subsystem.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            case BLUE:{
                if(!m_subsystem.isBlue()){
                    m_subsystem.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            case YELLOW:{
                if(!m_subsystem.isYellow()){
                    m_subsystem.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            System.out.println("Trying to match color: "+ m_color);
        }
    }

    private SpinnerColor offsetColor(SpinnerColor color){
        switch(color){
            case RED:{
             return SpinnerColor.BLUE;
                }
            case GREEN:{
               return SpinnerColor.YELLOW;
                }

            case BLUE:{
                return SpinnerColor.RED;
                }

            case YELLOW:{
                return SpinnerColor.GREEN;
                }

        }
        return color;
    }

}
