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

	// 'S' or 'C'
	private char m_scaleAction;
	public AutoCommand(char start_pos, char scaleAction,String fieldString) 
	{
		m_position = start_pos;
		m_scaleAction = scaleAction;
		m_mySwitch = fieldString.charAt(0);
		m_scale = fieldString.charAt(1);
		m_theirSwitch = fieldString.charAt(2);

		addSequential(new DriveCommand(-5*12));
		/*
		addSequential(new TurnCommand(30));
		addSequential(new WaitCommand(5));
		addSequential(new DriveCommand(2000));		*/
		
		if(m_position == 'C')
		{
			//starting in center. only option is switch
			placeSwitch(m_mySwitch);
		}
		else if(m_position == m_scale)
		{
			//means scale is on our starting side
			placeScaleEasy(m_position);
		}
		else if(m_scaleAction == 'S')
		{
			//this is if we want to plat it safe and not cross the feild for scale
			crossLine();
		}
		else
		{
			placeScaleCross(m_position);
		}
	}
	
	private void placeSwitch(char turn)
	{
		// Values are temporary and aren't the real distances.
		int leftRight = (turn == 'R') ? 1 : -1;
		// needes some kind of output system lowerer(the numatics)
		addSequential(new DriveCommand(1 * 12));
		addSequential(new TurnCommand(leftRight * 30));
		addSequential(new DriveCommand(1 * 12));
		addSequential(new TurnCommand(leftRight * (-30)));
		addSequential(new DriveCommand(1 * 12));
		// some sort of elevator up
		addSequential(new OutputCommand(1));
		addSequential(new DriveCommand(-1 * 12));
		addSequential(new TurnCommand(leftRight * 30));
		addSequential(new DriveCommand(1 * 12));
		addSequential(new TurnCommand(leftRight * (-30)));
		addSequential(new DriveCommand(1 * 12));
	}
	
	private void placeScaleEasy(char start)
	{
		
	}
	
	private void placeScaleCross(char start)
	{
		
	}
	
	private void crossLine()
	{
		addSequential(new DriveCommand(5 * 12));
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
