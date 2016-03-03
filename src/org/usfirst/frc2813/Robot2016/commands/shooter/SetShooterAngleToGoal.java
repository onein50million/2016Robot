package org.usfirst.frc2813.Robot2016.commands.shooter;

import org.usfirst.frc2813.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class SetShooterAngleToGoal extends Command {

    public SetShooterAngleToGoal() {
    	requires(Robot.shooterAim);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.autoShooterValues = TrajectorySimulator.findTrajectory(); // this is temp
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.autoShooterValues[0];
    	Robot.shooterAim.enablePID();
    	Robot.shooterAim.setAngle(angle);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.shooterAim.getPointedAtGoal()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterAim.setPointedAtGoal(false);
    	//    	Robot.shooterAim.disablePID();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooterAim.setPointedAtGoal(false);
    	//    	Robot.shooterAim.disablePID();
  
    }
    
}
