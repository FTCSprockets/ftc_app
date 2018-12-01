package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Benla on 11/14/2018.
 */

@Autonomous(group = "Sprockets", name = "Basic Left")
public class AutoHangLeft extends SprocketsBaseAutonomous
{
    public void DriveTheRobot ()
    {
        TurnLeftDegrees(AutonomousBaseSpeed, 45);

        DriveForwardsDistance(AutonomousBaseSpeed, 45);

        TurnRightDegrees(AutonomousBaseSpeed, 90);

        DriveForwardsDistance(AutonomousBaseSpeed, 40);

        DropMarker();

        DriveBackwards(AutonomousBaseSpeed, 80);
    }
}
