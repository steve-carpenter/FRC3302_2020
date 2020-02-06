package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.enums.BlinkinPattern;
import frc.robot.enums.RobotFeedback;

public class EnableLEDs extends CommandBase {

    public EnableLEDs() {
        addRequirements(Robot.lED);
    }

    @Override
    public void initialize() {
        Robot.lED.setPattern(BlinkinPattern.LARSON_SCANNER);
    }

    @Override
    public void execute() {
        RobotFeedback rf = RobotFeedback.CLIMBING;
        switch(rf){
            case CLIMBING: {
                Robot.lED.setPattern(BlinkinPattern.CONFETTI);
                break;
            }
            case HANGING: {
                Robot.lED.setPattern(BlinkinPattern.FIRE_LARGE);
                break;
            }
            case SHOOOTER_AT_SPEED: {
                Robot.lED.setPattern(BlinkinPattern.LARSON_SCANNER);
                break;
            }
            default:{
                Robot.lED.setPattern(BlinkinPattern.CONFETTI);
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
        Robot.lED.stop();
    }

}
