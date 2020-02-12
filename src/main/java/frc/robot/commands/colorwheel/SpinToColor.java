
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SpinToColor extends CommandBase {
    private RobotContainer m_subsystem;
    private SpinnerColor m_color;

    public enum SpinnerColor{
        BLUE,
        RED,
        GREEN,
        YELLOW
    }

    public SpinToColor(RobotContainer subsystem, SpinnerColor color) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_colorwheel);
        color = this.m_color;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        switch(m_color){
            case RED:{
                if(!m_subsystem.m_colorwheel.isRed()){
                    m_subsystem.m_colorwheel.spinColorWheel();
                }
                else{
                    end(false);
                }
            }
            case GREEN:{
                if(!m_subsystem.m_colorwheel.isGreen()){
                    m_subsystem.m_colorwheel.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            case BLUE:{
                if(!m_subsystem.m_colorwheel.isBlue()){
                    m_subsystem.m_colorwheel.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            case YELLOW:{
                if(!m_subsystem.m_colorwheel.isYellow()){
                    m_subsystem.m_colorwheel.spinColorWheel();
                }
                else{
                    end(false);
                }

            }
            System.out.println("Trying to match color: "+ m_color);
        }

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_colorwheel.stopColorWheel();
    }

}
