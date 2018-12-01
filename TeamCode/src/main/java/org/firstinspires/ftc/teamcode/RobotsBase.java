package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.InterruptedException;

/**
 * Created by Benla on 10/14/2018.
 */

@Disabled
public abstract class RobotsBase extends LinearOpMode
{
    public DcMotor leftDrive;
    public DcMotor rightDrive;

    public Servo leftClaw;
    public Servo rightClaw;

    public abstract void DefineOpMode();

    public static final int inchConstant = 22; // this is a little low, so add a few inches to any long-distance value.

    public static final int degConstant = 3; // this is high so subtract a few

    public static final double AutonomousBaseSpeed = 0.5;

    public boolean RobotIsGoingForwards = true;

    public double LeftClawOpenPosition = 0;
    public double LeftClawClosedPosition = .5;
    public double LeftClawBackPosition = 1;

    public double RightClawOpenPosition = 1;
    public double RightClawClosedPosition = .5;
    public double RightClawBackPosition = 0;

    @Override
    public void runOpMode() throws InterruptedException
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");


        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);


        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DefineOpMode();
    }


    //Here is a set of methods for everything the robot needs to do.  These can be used anywhere.

    //Utility Methods

    public void DriveMotors (double speed)
    {
        leftDrive.setPower(speed);
        rightDrive.setPower(speed);
    }

    public void ChangeDirection ()
    {
        leftDrive.getMode();
        if (leftDrive.getDirection() == DcMotorSimple.Direction.FORWARD
                && rightDrive.getDirection() == DcMotorSimple.Direction.REVERSE)
        {
            leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
            rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

            RobotIsGoingForwards = false;
        } else
        {
            leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
            rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

            RobotIsGoingForwards = true;
        }
    }

    public void OffTheLander ()
    {

    }


    //Movement Methods

    public void DriveForwardsOrBackwards (double speed)
    {
        DriveMotors(speed);
    }

    public void TurnLeft (double speed)
    {
        leftDrive.setPower(-speed);
        rightDrive.setPower(speed);
    }

    public void TurnRight (double speed)
    {
        leftDrive.setPower(speed);
        rightDrive.setPower(-speed);
    }

    public void StopDriving ()
    {
        DriveMotors(0);
    }

    public void DriveForwardsDistance (double speed, int inches)
    {
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftDrive.setTargetPosition(inches*inchConstant);
        rightDrive.setTargetPosition(inches*inchConstant);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForwardsOrBackwards(speed);

        while (leftDrive.isBusy() && rightDrive.isBusy())
        {

        }

        StopDriving();

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void DriveBackwards (double speed, int inches)
    {
        ChangeDirection();

        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftDrive.setTargetPosition(inches*inchConstant);
        rightDrive.setTargetPosition(inches*inchConstant);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForwardsOrBackwards(speed);

        while (leftDrive.isBusy() && rightDrive.isBusy())
        {

        }

        StopDriving();

        if (RobotIsGoingForwards == true)
        {

        } else
        {
            ChangeDirection();
        }

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void TurnLeftDegrees (double speed, int degrees)
    {
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftDrive.setTargetPosition(-degrees*degConstant);
        rightDrive.setTargetPosition(degrees*degConstant);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForwardsOrBackwards(speed);

        while (leftDrive.isBusy() && rightDrive.isBusy())
        {

        }

        StopDriving();

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void TurnRightDegrees(double speed, int degrees)
    {
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftDrive.setTargetPosition(degrees*degConstant);
        rightDrive.setTargetPosition(-degrees*degConstant);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForwardsOrBackwards(speed);

        while (leftDrive.isBusy() && rightDrive.isBusy())
        {

        }

        StopDriving();

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void ClawOut ()
    {

    }

    public void DropMarker ()
    {

    }
}