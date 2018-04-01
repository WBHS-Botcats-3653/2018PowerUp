package org.usfirst.frc.team3653.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team3653.robot.subsystems.Intake;

/**
 *
 */
public class OutputCommand extends Command {
	private final Intake m_intake;
	private int m_duration;
	private final Timer m_timer;

    public OutputCommand(int duration)
    {
    	m_duration = duration;
    	m_timer = new Timer();
    	m_intake = Intake.getInstance();
		requires(m_intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	m_intake.deployAndStow( false );
    	m_timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	if (m_timer.get() > 1)
    	{
    		m_intake.intake(1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	return m_timer.get() > (1+m_duration);
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
