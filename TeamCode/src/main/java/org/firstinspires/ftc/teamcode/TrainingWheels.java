package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Benla on 11/24/2018.
 */

@TeleOp(group = "Sprockets", name = "Training Wheels")
public class TrainingWheels extends LinearOpMode
{
    public DcMotor leftDrive;
    public DcMotor rightDrive;

    public void runOpMode() throws InterruptedException
    {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive())
        {
            leftDrive.setPower(-gamepad1.left_stick_y - .1);
            rightDrive.setPower(-gamepad1.right_stick_y);

            if (gamepad1.x)
            {
                leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                leftDrive.setTargetPosition(220);
                rightDrive.setTargetPosition(220);

                leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                leftDrive.setPower(0.5);
                rightDrive.setPower(0.5);

                while (leftDrive.isBusy() && rightDrive.isBusy())
                {

                }

                leftDrive.setPower(0);
                rightDrive.setPower(0);

                leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }

            if (gamepad1.y)
            {
                leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                leftDrive.setTargetPosition(-90*3);
                rightDrive.setTargetPosition(90*3);

                leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                leftDrive.setPower(0.5);
                rightDrive.setPower(0.5);

                while (leftDrive.isBusy() && rightDrive.isBusy())
                {

                }

                leftDrive.setPower(0);
                rightDrive.setPower(0);

                leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }

            idle();
        }
    }
}
