// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  
  TalonSRX elevator = new TalonSRX(7);
  TalonSRX wrist = new TalonSRX(5);
  VictorSPX IntakeMotor = new VictorSPX(10);
  
  
  public Elevator() {
    elevator.setNeutralMode(NeutralMode.Brake);
    elevator.configFactoryDefault();
    elevator.setSelectedSensorPosition(0);
    elevator.config_kP(0, .0001);
    elevator.config_kI(0, .0001);
    elevator.config_kD(0,.0001);
    elevator.selectProfileSlot(0, 0);

    wrist.setNeutralMode(NeutralMode.Brake);
    wrist.configFactoryDefault();

    // winch.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void controlElevator(double winchOutput){
    elevator.set(TalonSRXControlMode.PercentOutput,-winchOutput );
    
    
  }
  public void controlWrist(double winchOutput){
    wrist.set(TalonSRXControlMode.PercentOutput,-winchOutput );
   
    
  }
 public void runIntake(double winchOutput){
    
    IntakeMotor.set(VictorSPXControlMode.PercentOutput, winchOutput);
    
  }

  public void stopElevator(){
    elevator.set(TalonSRXControlMode.PercentOutput,0);
  }

  public void stopWrist(){
    
    wrist.set(TalonSRXControlMode.PercentOutput,0);
    
  }
  public void stopIntake(){
    IntakeMotor.set(VictorSPXControlMode.PercentOutput,0);
  }

  public void encoder(){
    System.out.println(elevator.getSelectedSensorPosition());
  }

  public void setEncoder(double value){
    elevator.set(ControlMode.Position, value);
  }
}
