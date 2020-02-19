package frc.robot.utils;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TunableBoolean {
  private String key;
  private boolean defaultValue;

  /**
   * Create a new TunableNumber
   * 
   * @param dashboardKey Key on dashboard
   */

  public TunableBoolean(String dashboardKey, boolean defaultValue) {
      this.key = dashboardKey;
      this.defaultValue = defaultValue;
    }
  
    /**
     * Get the default value for the number that has been set
     * 
     * @return The default value
     */
    public boolean getDefault() {
      return defaultValue;
    }
  
    /**
     * Set the default value of the number
     * 
     * @param defaultValue The default value
     */
    public void setDefault(boolean defaultValue) {
      this.defaultValue = defaultValue;
      SmartDashboard.putBoolean(key, SmartDashboard.getBoolean(key, defaultValue));
    }
  
    /**
     * Get the current value, from dashboard if available and in tuning mode
     * 
     * @return The current value
     */
    public boolean get() {
      return SmartDashboard.getBoolean(key, defaultValue);
    }
  }