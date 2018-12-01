package org.firstinspires.ftc.teamcode;

/**
 * Created by Benla on 12/1/2018.
 */

public abstract class SprocketsBaseAutonomous extends RobotsBase
{
    public abstract void DriveTheRobot ();

    public void DefineOpMode ()
    {
        leftClaw.setPosition(LeftClawOpenPosition);
        rightClaw.setPosition((RightClawClosedPosition));

        waitForStart();

        OffTheLander();

        DriveTheRobot ();
    }
}
