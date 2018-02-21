package org.usfirst.frc.team3653.robot.subsystems;

import org.usfirst.frc.team3653.robot.RobotMap;
import org.usfirst.frc.team3653.robot.commands.ArcadeLiftCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class Elevator extends Subsystem
{
    private static Elevator m_singleton = null;
    private WPI_TalonSRX m_elevatorMotorMaster;
    private WPI_TalonSRX m_elevatorMotorSlave;
    //private DigitalInput m_upperLimit;
    //private DigitalInput m_lowerLimit;

    private Elevator()
    {
    	m_elevatorMotorMaster = new WPI_TalonSRX (RobotMap.canElevatorMotorMaster);
    	m_elevatorMotorSlave = new WPI_TalonSRX (RobotMap.canElevatorMotorSlave);
    	//m_upperLimit = new DigitalInput(RobotMap.dioElevatorUpper);
    	//m_lowerLimit = new DigitalInput(RobotMap.dioElevatorLower);
    	
    	m_elevatorMotorSlave.follow(m_elevatorMotorMaster);

    	m_elevatorMotorMaster.configSelectedFeedbackSensor(
    	        com.ctre.phoenix.motorcontrol.FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	m_elevatorMotorMaster.setSensorPhase( true );
    }

    public void initDefaultCommand()
    {
    	// Set the default command for a subsystem here.
    	setDefaultCommand(new ArcadeLiftCommand());
    }
    
    // negative speed is down and a posotive speed is up
    public boolean lift(double speed)
    {
    	boolean ret_val = false;
    	if((speed > 0 && isUpperLimit()) || (speed < 0 && isLowerLimit() ))
    	{
    		ret_val = true;
    		speed = 0;
    	}
    	m_elevatorMotorMaster.set(speed);
		SmartDashboard.putNumber( "Elevator Position", this.getPosition() );
    	return ret_val;
    }

    public boolean isUpperLimit()
    {
    	return false; //m_upperLimit.get();
    }

    public boolean isLowerLimit()
    {
    	return false; //m_lowerLimit.get();
    }

    public static Elevator getInstance()
	{
		if(m_singleton ==  null)
		{
			m_singleton = new Elevator();
		}
		return m_singleton;
	}

	public void resetPosition()
	{
		m_elevatorMotorMaster.setSelectedSensorPosition(0, 0, 0);
	}

	public double getPosition( )
	{
		final double distPerCount = ( 1.756 * Math.PI ) / (2.083 * 4096 );
		return m_elevatorMotorMaster.getSelectedSensorPosition(0) * distPerCount;
	}
}

