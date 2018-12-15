package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Benla on 10/14/2018.
 */

/*

Controls:

GPAD 1 - Driver
Left Stick Up/Down = left wheel forward/back
Right Stick Up/Down = right wheel forward/back

GPAD 2 - Arms
Left Stick Up/Down = arms up/ down
Right Stick Up/Down = arms extend/retract

 */


@TeleOp (group = "Sprockets", name = "SrpktTeleOp")
@Disabled
public class SprocketsTeleOp extends RobotsBase
{
    @Override
    public void DefineOpMode ()
    {
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive())
        {
            leftDrive.setPower(-gamepad1.left_stick_y/2);
            rightDrive.setPower(-gamepad1.right_stick_y/2);

            telemetry.update();

            idle();
        }
    }
}
