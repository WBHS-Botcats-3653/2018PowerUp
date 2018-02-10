package org.usfirst.frc.team3653.robot;

import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static int leftDriveMotor = 2;
	public static int rightDriveMotor = 3;
	public static SPI.Port gyro_port = SPI.Port.kOnboardCS0;
	public static int encoder_channel = 0;
	// vvv these are the transmitions for shifting gears for the drive vvv
	public static int shiftFC = 0; //forward channel
	public static int shiftRC = 1; //reverse channel
	
}
