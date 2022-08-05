// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Driving;
import frc.robot.subsystems.DriveTrainMain;
import frc.robot.subsystems.Pose;

public class Drive {
    Joystick driver;   

    public static CANSparkMax lMotor1; 
    public static CANSparkMax lMotor2;     
    public static CANSparkMax lMotor3; 
    public static CANSparkMax rMotor1; 
    public static CANSparkMax rMotor2; 
    public static CANSparkMax rMotor3; 

    public static RelativeEncoder lEncoder; 
    public static RelativeEncoder rEncoder;

    public static DriveTrainMain driveTrain; 
    
    Pose robotPose; 

    public Drive(Joystick driver){
        init(driver);
    }

    public void init(Joystick driver){
        this.driver = driver; 

        lMotor1 = new CANSparkMax(1, MotorType.kBrushless); 
        lMotor2 = new CANSparkMax(2, MotorType.kBrushless);
        lMotor3 = new CANSparkMax(3, MotorType.kBrushless);
        rMotor1 = new CANSparkMax(4, MotorType.kBrushless);                
        rMotor2 = new CANSparkMax(5, MotorType.kBrushless);            
        rMotor3 = new CANSparkMax(6, MotorType.kBrushless);  
        
        
        lMotor1.restoreFactoryDefaults();
        lMotor2.restoreFactoryDefaults();
        lMotor3.restoreFactoryDefaults();

        rMotor1.restoreFactoryDefaults();
        rMotor2.restoreFactoryDefaults();
        rMotor3.restoreFactoryDefaults();

        lMotor2.follow(lMotor1, false);
        lMotor3.follow(lMotor1, false);

        rMotor2.follow(rMotor1, false);
        rMotor3.follow(rMotor1, false);

        RelativeEncoder lEncoder = lMotor1.getEncoder();
        RelativeEncoder rEncoder = rMotor1.getEncoder();

        setCurrentLimit(38);

        robotPose = new Pose(lEncoder, rEncoder);
        robotPose.resetOdometry(new Pose2d(0, 0, new Rotation2d(0)));
        driveTrain = new DriveTrainMain(lMotor1, rMotor1, driver, robotPose); 
        driveTrain.setDefaultCommand(new Driving(driveTrain, driver));
        
    }

    public static void setCurrentLimit(int limit){
        lMotor1.setSmartCurrentLimit(limit);
        lMotor2.setSmartCurrentLimit(limit);
        lMotor3.setSmartCurrentLimit(limit);
        rMotor1.setSmartCurrentLimit(limit);
        rMotor2.setSmartCurrentLimit(limit);
        rMotor3.setSmartCurrentLimit(limit);
    }
}
