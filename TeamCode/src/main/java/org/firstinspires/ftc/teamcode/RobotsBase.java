package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by Benla on 10/14/2018.
 */

@Disabled
public abstract class RobotsBase extends LinearOpMode
{
    public DcMotor leftDrive;
    public DcMotor rightDrive;

    public DcMotor ArmRaiser;
    public DcMotor ClawThingy;
    public DcMotor armHelper;

    public Servo LeftClaw;
    public Servo RightClaw;


    public abstract void DefineOpMode() throws InterruptedException;

    public static final int inchConstant = 22; // this is a little low, so add a few inches to any long-distance value.

    public static final int degConstant = 3; // this is high so subtract a few

    public static final double AutonomousBaseSpeed = 0.5;

    public boolean RobotIsGoingForwards = true;

    public double LeftClawOpenPosition = 0;
    public double LeftClawClosedPosition = 1;


    public double RightClawOpenPosition = 1;
    public double RightClawClosedPosition = 0;


    @Override
    public void runOpMode() throws InterruptedException
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //map
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        ArmRaiser = hardwareMap.dcMotor.get("ArmRaiser");
        ClawThingy = hardwareMap.dcMotor.get("Clawthingy");
        armHelper = hardwareMap.dcMotor.get("armHelper");

        LeftClaw = hardwareMap.servo.get("LeftClaw");
        RightClaw = hardwareMap.servo.get("RightClaw");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ArmRaiser.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ClawThingy.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armHelper.setPower(ArmRaiser.getPower());


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

    public void OffTheLander () throws InterruptedException {
        ArmUpOrDown(.2, 200);

        LanderOpen();

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

    public void DriveForwardsTime (long time)
    {
        DriveMotors(AutonomousBaseSpeed);
        Thread.sleep(time);
    }

    public void DriveBackwardsTime (long time)
    {
        DriveMotors(-AutonomousBaseSpeed);
        Thread.sleep(time);
    }

    public void TurnLeftTime (long time)
    {
        leftDrive.setPower(-AutonomousBaseSpeed);
        rightDrive.setPower(AutonomousBaseSpeed);
        Thread.sleep(time);
    }

    public void TurnRightTime (long time)
    {
        leftDrive.setPower(AutonomousBaseSpeed);
        rightDrive.setPower(-AutonomousBaseSpeed);
        Thread.sleep(time);
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


    //Arm methods

    public void ArmUpOrDown (double power, long time) throws InterruptedException
    {
        ArmRaiser.setPower(power);
        Thread.sleep (time);
        ArmRaiser.setPower(0);
    }

    public void DropMarker () throws InterruptedException {

        ClawOpen();
        ArmUpOrDown(-.2, 200);
    }

    public void LanderOpen () throws InterruptedException
    {
        ClawThingy.setPower(-.2);
        Thread.sleep (110);
        ClawThingy.setPower(0);
    }

    public void LanderClose () throws InterruptedException
    {
        ClawThingy.setPower(.2);
        Thread.sleep (110);
        ClawThingy.setPower(0);
    }

    public void ClawOpen ()
    {
        LeftClaw.setPosition(LeftClawOpenPosition);
        RightClaw.setPosition(RightClawOpenPosition);
    }

    public void ClawClosed ()
    {
        LeftClaw.setPosition(LeftClawClosedPosition);
        RightClaw.setPosition(RightClawClosedPosition);
    }
}

