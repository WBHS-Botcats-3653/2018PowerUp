package org.usfirst.frc.team3653.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3653.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveCommand extends Command {
	private static final double m_defaultSpeed = 0.5;
	private static final double m_diameter = 6.0;
	private static final int m_maxVal = 4096;
	private double m_distance;
	private final double m_speed;
	private final Drive m_drive;
	private int m_revs;
	private int m_previousVal;
	private int m_currentVal;
	
	public DriveCommand(double distance, double speed) 
	{
		super( "Drive " + (int)distance );
		m_distance = distance;
		m_speed = speed;
		//m_direction = distance > 0 ? +1 : -1;
		m_drive = Drive.getInstance();
		requires(m_drive);
		
	}
	public DriveCommand(double distance) 
	{
		this(distance,m_defaultSpeed);
	}
	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		m_drive.resetEncoder();
		m_revs = 0;
		m_previousVal = 0;
		m_currentVal = 0;
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		
		m_currentVal = m_drive.getEncoder();

		if( m_currentVal > (m_previousVal+m_maxVal/2))
		{
			m_revs--;
			System.out.println(m_revs);
		}
		else if(m_currentVal < (m_previousVal - m_maxVal/2))
		{
			m_revs++;
			System.out.println(m_revs);
		}
		m_previousVal = m_currentVal;
		m_drive.arcadeDrive(m_speed* (m_distance < 0 ? -1 : +1), 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		double currentDistance =(m_revs + (double)m_currentVal/m_maxVal)* Math.PI*m_diameter;
		SmartDashboard.putNumber("distance",currentDistance);
		
		if( Math.abs(m_distance) - Math.abs(currentDistance)  <= 0 )
		{
			System.out.println("command complete");
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		m_drive.arcadeDrive(0, 0);
	}
		
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
