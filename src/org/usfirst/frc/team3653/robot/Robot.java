
package org.usfirst.frc.team3653.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.DriverStation;


//import org.usfirst.frc.team3653.robot.commands.ExampleCommand;
import org.usfirst.frc.team3653.robot.subsystems.Drive;
import org.usfirst.frc.team3653.robot.commands.AutoCommand;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI m_oi = null;
	private Command autonomousCommand = null;
	private Drive m_drive =  null;
	private Compressor m_compressor = null;

	SendableChooser<Character> m_chooser = null;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		m_oi = OI.getInstance();
		m_drive = Drive.getInstance();
		m_chooser = new SendableChooser<>();
		m_compressor = new Compressor();

		m_chooser.addObject("Left", new Character('L'));
		m_chooser.addDefault("Center", new Character('C'));
		m_chooser.addObject("Right", new Character('R'));
		m_compressor.setClosedLoopControl(true);

		SmartDashboard.putData("Start Position", m_chooser);
		//SmartDashboard.putData("Scheduler", Scheduler.getInstance());
		SmartDashboard.putData("Drive", Drive.getInstance());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit()
	{
		m_drive.arcadeDrive( 0, 0 );
	}

	@Override
	public void disabledPeriodic()
	{
		m_compressor.setClosedLoopControl(false);
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit()
	{
		Character c = m_chooser.getSelected();
		autonomousCommand = new AutoCommand(
				c.charValue(),
				DriverStation.getInstance().getGameSpecificMessage() );
		m_compressor.setClosedLoopControl(true);
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
		{
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		m_compressor.setClosedLoopControl(true);

		if (autonomousCommand != null)
		{
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test modea
	 */
	@Override
	public void testPeriodic()
	{
		//LiveWindow.run();
	}
}