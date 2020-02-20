package frc.robot.commands.leds;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.enums.BlinkinPattern;
import frc.robot.enums.RobotFeedback;

public class EnableLEDs extends CommandBase {

    private RobotContainer m_subsystem;

    public EnableLEDs(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_led);
    }

    @Override
    public void initialize() {
        m_subsystem.m_led.setPattern(BlinkinPattern.LARSON_SCANNER);
    }

    @Override
    public void execute() {
        RobotFeedback rf = RobotFeedback.CLIMBING;
        switch(rf){
            case CLIMBING: {
                m_subsystem.m_led.setPattern(BlinkinPattern.CONFETTI);
                break;
            }
            case HANGING: {
                m_subsystem.m_led.setPattern(BlinkinPattern.FIRE_LARGE);
                break;
            }
            case SHOOOTER_AT_SPEED: {
                m_subsystem.m_led.setPattern(BlinkinPattern.LARSON_SCANNER);
                break;
            }
            default:{
                m_subsystem.m_led.setPattern(BlinkinPattern.CONFETTI);
                break;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_led.stop();
    }

}
