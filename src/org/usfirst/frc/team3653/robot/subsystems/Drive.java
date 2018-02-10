package org.usfirst.frc.team3653.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import org.usfirst.frc.team3653.robot.RobotMap;
import org.usfirst.frc.team3653.robot.commands.ArcadeDriveCommand;



/**
 *
 */
public class Drive extends Subsystem
{
	private static Drive m_singleton = null;
	private Victor m_leftDrive, m_rightDrive;
	private DifferentialDrive m_drive;
	private ADXRS450_Gyro m_gyro;
	private DoubleSolenoid m_transmition;
	private AnalogInput m_encoder;
	private int m_encoder0;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() 
	{
		// Set the default command for a subsystem here.
		setDefaultCommand( new ArcadeDriveCommand() );
	}

	private Drive()
	{
		m_rightDrive = new Victor (RobotMap.rightDriveMotor);
		m_leftDrive = new Victor (RobotMap.leftDriveMotor);
		m_drive = new DifferentialDrive (m_leftDrive,m_rightDrive);
		m_gyro = new ADXRS450_Gyro(RobotMap.gyro_port);
		m_transmition = new DoubleSolenoid(RobotMap.shiftFC,RobotMap.shiftRC);
		m_encoder = new AnalogInput(RobotMap.encoder_channel);
		m_encoder0 = 0;

		SmartDashboard.putData("Gyro", m_gyro);
	}
	public int getEncoder()
	{
		return m_encoder.getValue() - m_encoder0;
	}
	public void resetEncoder()
	{
		m_encoder0 = m_encoder.getValue();
	}
	public double getAngle()
	{
		return m_gyro.getAngle();
	}

	public void resetAngle()
	{
		m_gyro.reset();
	}

	public void arcadeDrive(double xSpeed, double zRotation)
	{
		m_drive.arcadeDrive(xSpeed, zRotation);
	}
	public void shift(boolean up)
	{
		m_transmition.set(up ? Value.kForward : Value.kReverse);
	}

	public static Drive getInstance()
	{
		if(m_singleton ==  null)
		{
			m_singleton = new Drive();
		}
		return m_singleton;
	}
}
