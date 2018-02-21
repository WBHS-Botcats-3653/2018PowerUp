package org.usfirst.frc.team3653.robot.subsystems;

import org.usfirst.frc.team3653.robot.RobotMap;
import org.usfirst.frc.team3653.robot.commands.ArcadeIntakeCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem 
{
	private static Intake m_singleton = null;
    private VictorSP m_intakeMotor;
    private DoubleSolenoid m_armCtrl;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Intake()
    {
    	m_armCtrl = new DoubleSolenoid(RobotMap.pcmCanIntakeArm, RobotMap.pcmFCIntakeArm, RobotMap.pcmRCIntakeArm);
    	//deploy();
    	m_intakeMotor = new VictorSP (RobotMap.pwmIntakeMotor);
    }
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new ArcadeIntakeCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // I didnt know if it was set up like this for a reason
    // so i just comented it out
    /*public void deploy()
    {
    	m_armCtrl.set(Value.kForward);
    }
    
    public void stow()
    {
    	m_armCtrl.set(Value.kReverse);
    }*/
    
    public void deployAndStow(boolean up)
   	{
   		m_armCtrl.set(up ? Value.kReverse : Value.kForward);
   	}
    
    public void intake(double speed)
    {
    	m_intakeMotor.setSpeed(speed);
    }

	public static Intake getInstance()
	{
		if(m_singleton ==  null)
		{
			m_singleton = new Intake();
		}
		return m_singleton;
	}
}

