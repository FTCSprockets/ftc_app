package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
public abstract class VoltageBaseAutonomous extends VoltageBase
{
    public abstract void DriveTheRobot ();

    //if using vuforia, here is the place to initialize it.  I will figure that out soon.

    @Override
    public void DefineOpMode () {
        mineralArm.setPosition(mineralArm_Ground);
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }

        DriveTheRobot();
    }
}
