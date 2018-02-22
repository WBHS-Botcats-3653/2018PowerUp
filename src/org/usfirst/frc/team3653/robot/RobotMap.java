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
	public static int pwmLeftDriveMotor = 6;
	public static int pwmRightDriveMotor = 7;
	public static int pwmIntakeMotor = 1;
	public static int pwmClimbMotor = 2;

	public static SPI.Port spiGyroPort = SPI.Port.kOnboardCS0;

	public static int adcEncoderChannel = 0;

	public static int pcmCanCompressor = 2;
	// vvv these are the transmissions for shifting gears for the drive vvv
	public static int pcmCanShift = 1;
	public static int pcmFCShift = 0; //forward channel
	public static int pcmRCShift = 1; //reverse channel

	public static int pcmHook = 2; //for climbing

	public static int pcmCanIntakeArm = 1;
	public static int pcmFCIntakeArm = 2; //forward channel
	public static int pcmRCIntakeArm = 3; //reverse channel

	public static int dioElevatorUpper = 0;
	public static int dioElevatorLower = 1;

	public static int canElevatorMotorMaster = 10;
	public static int canElevatorMotorSlave = 9;
}
