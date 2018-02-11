package org.usfirst.frc.team3653.robot;

//import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

//import org.usfirst.frc.team3653.robot.subsystems.Drive;
//import org.usfirst.frc.team3653.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static OI m_singleton = null;
	private XboxController m_controller;

	private OI()
	{
		m_controller = new XboxController (0);
	}

	public static OI getInstance()
	{
		if(m_singleton ==  null)
		{
			m_singleton = new OI();
		}
		return m_singleton;
	}

	public double getThrottle()
	{
		return m_controller.getY(GenericHID.Hand.kLeft);
	}

	public double getSteering()
	{
		//its negative because the getX was inverted
		return -m_controller.getX(GenericHID.Hand.kRight);
	}

	public boolean getShift()
	{
		return m_controller.getTriggerAxis(GenericHID.Hand.kLeft) < 0.5 ? false : true;
	}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
