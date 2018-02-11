package org.usfirst.frc.team3653.robot.subsystems;

import org.usfirst.frc.team3653.robot.RobotMap;
import org.usfirst.frc.team3653.robot.commands.ArcadeLiftCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem
{
    private static Elevator m_singleton = null;
    private VictorSP m_elevatorMotor;
    private DigitalInput m_upperLimit;
    private DigitalInput m_lowerLimit;

    private Elevator()
    {
    	m_elevatorMotor = new VictorSP (RobotMap.pwmElevatorMotor);
    	m_upperLimit = new DigitalInput(RobotMap.dioElevatorUpper);
    	m_lowerLimit = new DigitalInput(RobotMap.dioElevatorLower);
    }

    public void initDefaultCommand()
    {
    	setDefaultCommand(new ArcadeLiftCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // negative speed is down and a posotive speed is up
    public void lift(double speed)
    {
    	m_elevatorMotor.setSpeed(speed);
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

