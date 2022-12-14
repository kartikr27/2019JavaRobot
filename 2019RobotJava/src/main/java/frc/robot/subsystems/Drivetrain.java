// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  CANSparkMax FrontLeft = new CANSparkMax(16,MotorType.kBrushless);
  CANSparkMax FrontRight = new CANSparkMax(13,MotorType.kBrushless);
  CANSparkMax MiddleLeft = new CANSparkMax(1,MotorType.kBrushless);
  CANSparkMax MiddleRight = new CANSparkMax(14,MotorType.kBrushless);
  CANSparkMax BackLeft = new CANSparkMax(2,MotorType.kBrushless);
  CANSparkMax BackRight = new CANSparkMax(15,MotorType.kBrushless);
  public Drivetrain() {
    FrontLeft.setInverted(true);
    MiddleLeft.setInverted(true);
    BackLeft.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
}
public void sixMotors(double frontLeftOutput, double middleLeftOutput, double backLeftOutput,double frontRightOutput, double middleRightOutput,double backRightOutput){
  FrontLeft.set(frontLeftOutput*0.9);
  FrontRight.set(frontRightOutput*0.9);
  MiddleLeft.set(middleLeftOutput*0.9);
  MiddleRight.set(middleRightOutput*0.9);
  BackLeft.set(backLeftOutput*0.9);
  BackRight.set(backRightOutput*0.9);
  
}
}
