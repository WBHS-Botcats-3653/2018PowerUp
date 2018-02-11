package org.usfirst.frc.team3653.robot.commands;

import org.usfirst.frc.team3653.robot.OI;
import org.usfirst.frc.team3653.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeLiftCommand extends Command 
{
	private OI m_oi = null;
	private Elevator m_elevator = null;

    public ArcadeLiftCommand() 
    {
    	m_oi = OI.getInstance();
		m_elevator = Elevator.getInstance();

		requires( m_elevator );
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//m_elevator.shift(m_oi.getShift());
		m_elevator.lift(m_oi.getLift());
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
}
