package org.usfirst.frc2813.Robot2016.commands.arms;

import org.usfirst.frc2813.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmsIntake extends Command {

    public ArmsIntake() {
    	requires(Robot.arms);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arms.intake(0.65);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arms.intake(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.arms.intake(0);
    }
}