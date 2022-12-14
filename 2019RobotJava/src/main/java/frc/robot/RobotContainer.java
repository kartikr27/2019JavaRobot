// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Controller.Joysticks.dLeftActive;
import frc.robot.Controller.Joysticks.dLeftInactive;
import frc.robot.Controller.Joysticks.dRightActive;
import frc.robot.Controller.Joysticks.dRightInactive;
import frc.robot.commands.ControlElevator;
import frc.robot.commands.ControlWrist;
import frc.robot.commands.Drive;

import frc.robot.commands.IdleElevator;
import frc.robot.commands.IdleWrist;
import frc.robot.commands.MotionProfile;
import frc.robot.commands.ReverseIntake;
import frc.robot.commands.RunIntake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  

  
  private final Drivetrain m_drivetrain;
  private final Elevator m_elevator;

  private final XboxController d_controller = new XboxController(0);
  private final XboxController m_controller = new XboxController(1);

  private Trigger mRightJoystickActive = new dRightActive(m_controller);
  private Trigger mRightJoystickInactive = new dRightInactive(m_controller);

  private Trigger mLeftJoystickActive = new dLeftActive(m_controller);
  private Trigger mLeftJoystickInactive = new dLeftInactive(m_controller);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    m_drivetrain = new Drivetrain();
    m_elevator = new Elevator();

    m_drivetrain.setDefaultCommand(new Drive(m_drivetrain, d_controller));
    m_elevator.setDefaultCommand(new IdleElevator(m_elevator));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    mRightJoystickActive.whenActive(new ControlElevator(m_elevator, m_controller));
    mRightJoystickInactive.whenActive(new IdleElevator(m_elevator));

    mLeftJoystickActive.whenActive(new ControlWrist(m_elevator, m_controller));
    mLeftJoystickInactive.whenActive(new IdleWrist(m_elevator));
    
    new Button (m_controller :: getXButton).whenHeld(new RunIntake(m_elevator));
    new Button (m_controller :: getYButton).whenHeld(new ReverseIntake(m_elevator));
    new Button (m_controller :: getBButton).whenPressed(new MotionProfile(m_elevator));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
    
  // }
}
