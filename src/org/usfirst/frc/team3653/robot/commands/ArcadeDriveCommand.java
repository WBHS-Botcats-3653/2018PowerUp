package org.usfirst.frc.team3653.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3653.robot.subsystems.Drive;
import org.usfirst.frc.team3653.robot.OI;
/**
 *
 */
public class ArcadeDriveCommand extends Command
{
	private OI m_oi = null;
	private Drive m_drive = null;

	public ArcadeDriveCommand()
	{
		super( "Operator Control" );
		m_oi = OI.getInstance();
		m_drive = Drive.getInstance();

		requires( m_drive );
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		m_drive.shift(m_oi.getShift());
		m_drive.arcadeDrive(m_oi.getThrottle(), m_oi.getSteering());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
