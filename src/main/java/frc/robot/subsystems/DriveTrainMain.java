// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainMain extends SubsystemBase {
  /** Creates a new DriveTrainMain. */
  private MotorController leftMaster;
  private MotorController rightMaster;
  private Joystick driver;

  Pose pose; 

  private DifferentialDrive diffDrive; 

  public DriveTrainMain(MotorController leftMaster, MotorController rightMaster, Joystick driver, Pose robotPose) {
    this.leftMaster = leftMaster;
    this.rightMaster = rightMaster;
    this.driver = driver;
    this.pose = robotPose;

    diffDrive = new DifferentialDrive(leftMaster, rightMaster);


  }

  // public double driverModSteer(double steer, double throttle){
  //   return minMaxOne((deadzone(steer) * Constants.steerFactor) + (Math.abs(steer) > 0 && Math.abs(throttle) == 0 ? (Math.signum(steer)) * DriveConstants.ksVolts : 0));
  // }

  // public double driverModThrottle(double throttle){
  //   return minMaxOne((deadzone(throttle) * Constants.throttleFactor * Constants.driveInversion) + ((Math.signum(throttle)) * DriveConstants.ksVolts));
  // }

  public void arcadeDrive(double throttle, double steer) {
    throttle *= Constants.driveInversion;
    diffDrive.arcadeDrive(throttle, steer);
  }

  // public void curvatureDrive(double throttle, double steer){
  //   steer = driverModSteer(steer, throttle);
  //   throttle = driverModThrottle(throttle);

  //   diffDrive.curvatureDrive(throttle, steer, true);
  // }


  public static double scaleInputs(double input) {
    input = deadzone(input);
    return Math.pow(input, 3);

  }

  public static double deadzone(double input) {
    if (input > -.075 && input < .075) {
      return 0.0;
    }
    input = minMaxOne(input);
    
    return input;

  }

  public static double minMaxOne(double input){
    if (input > 1) {
      return 1;
    }
    if (input < -1) {
      return -1;
    }
    
    return input;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

