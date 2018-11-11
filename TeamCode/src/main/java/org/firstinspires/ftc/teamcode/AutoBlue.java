package org.firstinspires.ftc.teamcode;

/**
 * Created by Benla on 11/11/2018.
 */

public class AutoBlue extends BaseAutonomous
{
    public static final float mmBlueBaseX = 200;
    public static final float mmBlueBaseY = 200;

    public static final float mmMidBlueX = 100;
    public static final float mmMidBlueY = 100;

    public static final float mmCraterX = 100;
    public static final float mmCraterY = 100;


    @Override
    public void DriveTheRobot()
    {
        GoToDesiredPosition(mmMidBlueX, mmMidBlueY, AutonomousBaseSpeed);

        GoToDesiredPosition(mmBlueBaseX, mmBlueBaseY, AutonomousBaseSpeed);

        DropTheThingy();

        GoToDesiredPosition(mmCraterX, mmCraterY, AutonomousBaseSpeed);
    }
}
