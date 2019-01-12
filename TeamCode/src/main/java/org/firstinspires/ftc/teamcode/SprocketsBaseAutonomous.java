package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Benla on 12/1/2018.
 */

@Disabled
public abstract class SprocketsBaseAutonomous extends RobotsBase
{
    public abstract void DriveTheRobot () throws InterruptedException;

    public void DefineOpMode () throws InterruptedException
    {
        LeftClaw.setPosition(LeftClawOpenPosition);
        RightClaw.setPosition((RightClawClosedPosition));



        waitForStart();

        OffTheLander();

        DriveTheRobot ();
    }
}
