package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Benla on 10/14/2018.
 */

@Autonomous (group = "Sprockets", name = "Blue")
public class AutoRed extends BaseAutonomous
{
    public static final float mmRedBaseX = 200;
    public static final float mmRedBaseY = 200;

    public static final float mmMidRedX = 100;
    public static final float mmMidRedY = 100;

    public static final float mmCraterX = 100;
    public static final float mmCraterY = 100;


    @Override
    public void DriveTheRobot()
    {
        GoToDesiredPosition(mmMidRedX, mmMidRedY, AutonomousBaseSpeed);

        GoToDesiredPosition(mmRedBaseX, mmRedBaseY, AutonomousBaseSpeed);

        DropTheThingy();

        GoToDesiredPosition(mmCraterX, mmCraterY, AutonomousBaseSpeed);
    }
}
