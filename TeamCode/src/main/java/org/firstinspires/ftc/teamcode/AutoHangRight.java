package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Benla on 11/14/2018.
 */

@Autonomous(group = "Sprockets", name = "Basic Right")
public class AutoHangRight extends SprocketsBaseAutonomous
{
    public void DriveTheRobot () throws InterruptedException {
        DriveForwardsDistance(AutonomousBaseSpeed, 23);

        TurnLeftDegrees(AutonomousBaseSpeed, 90);

        DriveForwardsDistance(AutonomousBaseSpeed, 40);

        ArmUpOrDown(-.2, 200);

        TurnLeftDegrees(AutonomousBaseSpeed, 45);

        DriveForwardsDistance(AutonomousBaseSpeed, 54);

        DropMarker();

        DriveBackwards(AutonomousBaseSpeed, 84);
    }
}
