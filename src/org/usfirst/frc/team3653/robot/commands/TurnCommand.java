package org.usfirst.frc.team3653.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3653.robot.subsystems.Drive;

/**
 *
 */
public class TurnCommand extends Command {
	private final double m_turnSpeed = 0.5;
	private final double m_angle;
	private double m_startAngle;
	private final Drive m_drive;

	public TurnCommand(double angle)
	{
		m_angle = angle;
		m_drive = Drive.getInstance();
		requires(m_drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		m_startAngle = m_drive.getAngle();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		m_drive.arcadeDrive(0, m_angle < 0 ? -(m_turnSpeed) : m_turnSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return Math.abs(m_drive.getAngle() - m_startAngle) >= m_angle;
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
	protected void interrupted()
	{
	}
}
