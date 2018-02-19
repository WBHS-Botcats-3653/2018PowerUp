package org.usfirst.frc.team3653.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team3653.robot.RobotMap;
import org.usfirst.frc.team3653.robot.commands.ArcadeClimbCommand;

import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class Climber extends Subsystem 
{
	private static Climber m_singleton = null;
	private VictorSP m_climbMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new ArcadeClimbCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    private Climber()
    {
    	m_climbMotor = new VictorSP(RobotMap.pwmClimbMotor);
    }
    
    public void climber(double speed)
    {
    	m_climbMotor.setSpeed(speed);
    }
    
    public static Climber getInstance()
	{
		if(m_singleton ==  null)
		{
			m_singleton = new Climber();
		}
		return m_singleton;
	}
}

