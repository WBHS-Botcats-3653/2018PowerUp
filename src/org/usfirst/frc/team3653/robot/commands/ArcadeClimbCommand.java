package org.usfirst.frc.team3653.robot.commands;

import org.usfirst.frc.team3653.robot.OI;
import org.usfirst.frc.team3653.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeClimbCommand extends Command {

	private OI m_oi = null;
	private Climber m_climber = null;
	private int m_delay = 0;

	public ArcadeClimbCommand()
	{
		m_oi = OI.getInstance();
		m_climber = Climber.getInstance();

		requires( m_climber );
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		m_delay = 0;
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		m_climber.dropHook(m_oi.getHook());
		m_climber.wenchShift(m_oi.getWenchShift());
		m_climber.climber(m_oi.getClimber());
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
