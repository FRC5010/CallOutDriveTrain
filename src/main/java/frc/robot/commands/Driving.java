// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Drive;
import frc.robot.subsystems.DriveTrainMain;

public class Driving extends CommandBase {
  /** Creates a new Driving. */
  DriveTrainMain driveSubsystem;
  Joystick driver;
  public Driving(DriveTrainMain driveTrain, Joystick driver) {
    // Use addRequirements() here to declare subsystem dependencies.
      this.driver = driver;
      driveSubsystem = driveTrain;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Drive.setCurrentLimit(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.arcadeDrive(
      DriveTrainMain.scaleInputs(-driver.getRawAxis(Constants.throttle)), 
      DriveTrainMain.scaleInputs(driver.getRawAxis(Constants.steer)));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Drive.setCurrentLimit(38);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
