import edu.wpi.first.wpilibj2.command.CommandBase;

public class ManualTurret extends CommandBase{
   
    private RobotContainer m_subsystem;

    public AutoIntake(RobotContainer subsystem) {
        m_subsystem = subsystem;
        addRequirements(m_subsystem.m_intake);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystem.m_intake.collect();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.m_intake.run(0);
    }
}