// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  /** Creates a new Drive. */
  private final XboxController controller2;
  private final Drivetrain m_drivetrain;
  public Drive(Drivetrain drivetrain,XboxController controllerInput) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_drivetrain = drivetrain;
    this.controller2 = controllerInput;
    addRequirements(this.m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.sixMotors((controller2.getRawAxis(1)-controller2.getRawAxis(4)), (controller2.getRawAxis(1)-controller2.getRawAxis(4)), (controller2.getRawAxis(1)-controller2.getRawAxis(4)), (controller2.getRawAxis(1)+controller2.getRawAxis(4)), (controller2.getRawAxis(1)+controller2.getRawAxis(4)), (controller2.getRawAxis(1)+controller2.getRawAxis(4)));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
