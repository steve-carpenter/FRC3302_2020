package frc.robot.enums;

public enum BlinkinPattern {
        CONFETTI(-.87), FIRE_LARGE(-.57), LARSON_SCANNER(-0.01);

        private double sparkValue;

        BlinkinPattern(double sparkValue) {
            this.sparkValue = sparkValue;
        }

        public double getSparkValue() {
            return sparkValue;
        }
    }