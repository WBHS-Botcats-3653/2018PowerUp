package org.usfirst.frc.team3653.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class WaitCommand extends Command {
	
	private final Timer m_timer;
	private final double m_seconds;
	public WaitCommand(double seconds) 
	{
		m_seconds = seconds;
		m_timer = new Timer();
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		m_timer.start();
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		return m_timer.get() > m_seconds;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
