// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    static enum AxisNums {
        LEFT_Y, 
        RIGHT_X
        }

    public static int throttle = AxisNums.LEFT_Y.ordinal();
    public static int steer = AxisNums.RIGHT_X.ordinal();
    public static double throttleFactor = 0.7;    
    public static double steerFactor = 0.6;  
    public static final int driveInversion = 1; 
    public static final double wheelDiameter = 0.5 * (0.3048); // 12 * 0.0254 - feet to meters
    public static final double motorRotationsPerWheelRotation = 10.71; // i.e. gear ratio
    public static final double pulsesPerMotorRotation = 1.0; // Encoder PPR
    public static final double pulsesPerWheelRotation = pulsesPerMotorRotation * motorRotationsPerWheelRotation;

    public static final double wheelCircumference = wheelDiameter * Math.PI;
    public static final double distancePerPulse = wheelCircumference / pulsesPerWheelRotation;
    public static final double rpmToMetersPerSec = distancePerPulse / 60; // diameter divided by secs-per-minute

    public static final boolean gyroReversed = true;

    public static final boolean leftReversed = false;
    public static final boolean rightReversed = false;
    public static final double leftFudgeFactor = .98;
    public static final double rightFudgeFactor = .982;

    public static final double leftDistanceConv = distancePerPulse * (leftReversed ? -1.0 : 1.0) * leftFudgeFactor;
    public static final double rightDistanceConv = distancePerPulse * (rightReversed ? -1.0 : 1.0) * rightFudgeFactor;
    public static final double leftVelocityConv = rpmToMetersPerSec * (leftReversed ? -1.0 : 1.0) * leftFudgeFactor;
    public static final double rightVelocityConv = rpmToMetersPerSec * (rightReversed ? -1.0 : 1.0) * rightFudgeFactor;
}
