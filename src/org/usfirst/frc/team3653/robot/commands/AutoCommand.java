package org.usfirst.frc.team3653.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommand extends CommandGroup 
{
	// 'L', 'C', 'R'
	private char m_position;

	// The following will can be 'L' or 'R'
	private char m_mySwitch;
	private char m_scale;
	private char m_theirSwitch;

	public AutoCommand(char start_pos,String fieldString) 
	{
		m_position = start_pos;
		m_mySwitch = fieldString.charAt(0);
		m_scale = fieldString.charAt(1);
		m_theirSwitch = fieldString.charAt(2);
		int leftRight;

		addSequential(new DriveCommand(-5*12));
		/*
		addSequential(new TurnCommand(30));
		addSequential(new WaitCommand(5));
		addSequential(new DriveCommand(2000));		*/
		
		if(m_position == 'C')
		{
			//values are temporary and arnt the real distances.
			leftRight = (m_mySwitch =='R') ?  1 :  -1;
			addSequential(new DriveCommand(5*12));
			addSequential(new TurnCommand(leftRight*30));
			addSequential(new DriveCommand(5*12));
			addSequential(new TurnCommand(leftRight*(-30)));
			addSequential(new DriveCommand(5*12));
			//here is where the relese comand should be (box output)
			addSequential(new DriveCommand(-5*12));
			addSequential(new TurnCommand(leftRight*30));
			addSequential(new DriveCommand(5*12));
			addSequential(new TurnCommand(leftRight*(-30)));
			addSequential(new DriveCommand(5*12));
		}
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
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
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}
