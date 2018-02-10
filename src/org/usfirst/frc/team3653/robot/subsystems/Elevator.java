package org.usfirst.frc.team3653.robot.commands;

import org.usfirst.frc.team3653.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator extends Command {

	private static Elevator m_singleton = null;
    private Elevator() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    public static Elevator getInstance()
	{
		if(m_singleton ==  null)
		{
			m_singleton = new Elevator();
		}
		return m_singleton;
	}
}
