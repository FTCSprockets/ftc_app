package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Benla on 10/14/2018.
 */

/*



 */


@TeleOp (group = "Sprockets", name = "SprocketTeleOp")
public class SprocketsTeleOp extends RobotsBase
{
    @Override
    public void DefineOpMode() throws InterruptedException
    {
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive())
        {
            leftDrive.setPower(-gamepad1.left_stick_y);
            rightDrive.setPower(-gamepad1.right_stick_y);

            ArmRaiser.setPower(gamepad2.left_stick_y);


            if (gamepad2.a)
            {
                LanderOpen();
            }

            if (gamepad2.b)
            {
                LanderClose();
            }

            if (gamepad2.x)
            {
                ClawOpen();
            }

            if (gamepad2.y)
            {
                ClawClosed();
            }


            telemetry.update();

            idle();
        }
    }
}
