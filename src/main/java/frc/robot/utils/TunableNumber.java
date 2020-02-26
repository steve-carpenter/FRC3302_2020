package frc.robot.utils;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TunableNumber {
    private String key;
    private double defaultValue;
  
    /**
     * Create a new TunableNumber
     * 
     * @param dashboardKey Key on dashboard
     */
    public TunableNumber(String dashboardKey) {
      this.key = dashboardKey;
    }

    public TunableNumber(String dashboardKey, double defaultValue) {
        this.key = dashboardKey;
        this.defaultValue = defaultValue;
      }
  
    /**
     * Get the default value for the number that has been set
     * 
     * @return The default value
     */
    public double getDefault() {
      return defaultValue;
    }
  
    /**
     * Set the default value of the number
     * 
     * @param defaultValue The default value
     */
    public void setDefault(double defaultValue) {
      this.defaultValue = defaultValue;
      SmartDashboard.putNumber(key, SmartDashboard.getNumber(key, defaultValue));
    }
  
    /**
     * Get the current value, from dashboard if available and in tuning mode
     * 
     * @return The current value
     */
    public double get() {
      return SmartDashboard.getNumber(key, defaultValue);
    }
  }