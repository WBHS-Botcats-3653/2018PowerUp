package org.usfirst.frc.team3653.robot.commands;

import org.usfirst.frc.team3653.robot.OI;
import org.usfirst.frc.team3653.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeIntakeCommand extends Command
{
	private OI m_oi = null;
	private Intake m_intake = null;

	public ArcadeIntakeCommand()
	{
		m_oi = OI.getInstance();
		m_intake = Intake.getInstance();

		requires( m_intake );
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		m_intake.deployAndStow(m_oi.getIntakeDAS());
		m_intake.intake(m_oi.getIntake());
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
