package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.commands.Driving;
import frc.robot.subsystems.DriveTrainMain;

public class Drive {
    Joystick driver;
    Spark leftMotor, rightMotor;
    DriveTrainMain driveTrain; 

    public Drive(Joystick driver){
        init(driver); 
        
    }

    public void init(Joystick driver){
        this.driver = driver; 
        leftMotor = new Spark(1);
        rightMotor = new Spark(3);
        this.driveTrain = new DriveTrainMain(leftMotor, rightMotor, driver);
        driveTrain.setDefaultCommand(new Driving(driveTrain, driver));

    }

}
