package org.usfirst.frc.team3653.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3653.robot.subsystems.Elevator;
import org.usfirst.frc.team3653.robot.subsystems.Intake;

/**
 *
 */
public class LiftCommand extends Command {

	private final Elevator m_elevator;
	private double m_height;

	public LiftCommand( double height)
	{
		m_elevator = Elevator.getInstance();
		m_height = height;
		requires(m_elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		m_elevator.lift(0.6);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return m_height > m_elevator.getPosition();
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
