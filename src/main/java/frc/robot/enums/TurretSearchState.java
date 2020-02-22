package frc.robot.enums;

public enum TurretSearchState {
 
    PAN_LEFT {
        @Override
        public TurretSearchState next() {
            return PAN_RIGHT;
        }
    },
    PAN_RIGHT {
        @Override
        public TurretSearchState next() {
            return PAN_LEFT;
        }
    };
 
    public abstract TurretSearchState next(); 
}