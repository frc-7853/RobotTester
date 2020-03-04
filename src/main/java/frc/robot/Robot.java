/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class.
 * Runs the motors with arcade steering.
 */
public class Robot extends TimedRobot {
  private final Victor f_leftMotor = new Victor(0);
  private final Victor b_leftMotor = new Victor(1);
  private final Victor f_rightMotor = new Victor(2);
  private final Victor b_rightMotor = new Victor(3);
  private final Spark blinkin = new Spark(4);
  private final SpeedControllerGroup r_motors = new SpeedControllerGroup(f_rightMotor, b_rightMotor);
  private final SpeedControllerGroup l_motors = new SpeedControllerGroup(f_leftMotor, b_leftMotor);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(r_motors, l_motors);
  private final Joystick m_stick = new Joystick(0);

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    blinkin.set(0.9);
  }
}
