
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class FrontIntakeCollect extends CommandBase {

    public FrontIntakeCollect() {

        addRequirements(Robot.intake);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.intake.intakeFront(RobotMap.INTAKE_COLLECT_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.intake.intakeFront(0);
    }

}
