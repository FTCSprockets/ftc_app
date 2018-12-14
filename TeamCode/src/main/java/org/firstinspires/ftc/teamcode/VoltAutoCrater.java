package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Robin on 11/11/2018.
 **/

@Autonomous(group = "Voltage", name = "Crater Side")
public class VoltAutoCrater extends VoltageBaseAutonomous{

    @Override
    public void DriveTheRobot()
    {
        leftDrive.setTargetPosition(2000);
        rightDrive.setTargetPosition(2000);
        //STEP 1 = lower from lander
//        completeHookExtend (.5, stringInches);
//        TurnLeftDegrees(1,30);
//        DriveBackwardsDistance(1,4);
//        TurnRightDegrees(1,30);
//        telemetry.addData("Step 1 Executed", "Run Time: " + runtime.toString());
//        telemetry.update();
//
//        //STEP 2 = Drive to wall and orient
//        TurnLeftDegrees(1,45);
//        DriveBackwardsDistance(1,5);
//        TurnLeftDegrees(1,90);
//
//        //STEP 3 = Drive & place team marker
//        DriveBackwardsDistance(1, 12);
//
//        //STEP 4 = Place team marker
//        mineralArm.setPosition(mineralArm_Dump);
//        mineralArm.setPosition(mineralArm_Raised);
//
//        //STEP 5 = Drive forward into crater
//        DriveForwardsDistance(1,20);
//
//        //STEP 6 = Park in Crater
//        DriveForwardsDistance(0.5,4);
//        idle();

    }
}
