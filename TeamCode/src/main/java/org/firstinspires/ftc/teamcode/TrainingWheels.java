//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//
///**
// * Created by Benla on 11/24/2018.
// */
//
//@TeleOp(group = "Sprockets", name = "Training Wheels")
//public class TrainingWheels extends LinearOpMode
//{
//    public DcMotor leftDrive;
//    public DcMotor rightDrive;
//
//    public void runOpMode() throws InterruptedException
//    {
//        leftDrive = hardwareMap.dcMotor.get("leftDrive");
//        rightDrive = hardwareMap.dcMotor.get("rightDrive");
//
//        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//        waitForStart();
//
//        while (opModeIsActive())
//        {
//            leftDrive.setPower(-gamepad1.left_stick_y);
//            rightDrive.setPower(-gamepad1.right_stick_y);
//
//            idle();
//        }
//    }
//}
