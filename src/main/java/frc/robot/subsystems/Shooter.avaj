package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.utils.TunableNumber;

public class Shooter extends PIDSubsystem {

    private static TunableNumber P = new TunableNumber("Shooter PID (P)", 0.0012);
    private static TunableNumber I = new TunableNumber("Shooter PID (I)", 0);
    private static TunableNumber D = new TunableNumber("Shooter PID (D)", 0);
    private static TunableNumber rampRate = new TunableNumber("Shooter (Ramp Rate)", 2);
    public static final int kEncoderCPR = 1024;
    public static final double kEncoderDistancePerPulse =1.0 / (double) kEncoderCPR;
    public static final double kSVolts = 0.05;
    public static final double kShooterFreeRPS = 5300;
    public static final double kVVoltSecondsPerRotation = 12.0 / kShooterFreeRPS;
    private final Spark m_shooterMotor = new Spark(RobotMap.SHOOTER_FLYWHEEL_SPARK);
    private Encoder m_shooterEncoder = new Encoder(0,1,false);
    private final SimpleMotorFeedforward m_shooterFeedforward =new SimpleMotorFeedforward(kSVolts,kVVoltSecondsPerRotation);
   
        /**
         * The shooter subsystem for the robot.
         */
        public Shooter() {
          super(new PIDController(P.get(), I.get(), D.get()));
          getController().setTolerance(rampRate.get());
          m_shooterEncoder.setDistancePerPulse(kEncoderDistancePerPulse);
          setSetpoint(0);
        }
      
        @Override
        public void useOutput(double output, double setpoint) {
          m_shooterMotor.setVoltage(output + m_shooterFeedforward.calculate(setpoint));
        }
      
        @Override
        public double getMeasurement() {
          return m_shooterEncoder.getRate();
        }
      
        public boolean atSetpoint() {
          return m_controller.atSetpoint();
        }

        public double distanceToSpeed(double distance){
            // TODO distance formula here
            return 0.0;
        }

        public void stop(){
            setSetpoint(0);
        }
      }
