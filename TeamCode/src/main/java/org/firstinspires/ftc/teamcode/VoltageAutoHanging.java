package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Hanging", group="HangingAuto")
//@Disabled
public class VoltageAutoHanging extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();
    //Declare Motors
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor liftMotor;
    public DcMotor mineralMotor;

    //Declare Servos
    public Servo mineralArm;
    public final static double mineralArm_Ground = 0.0; //all the way down for servo

    //2000 ticks = 65"; // about 100 ticks = 3.35" each inch = 30.77
    //motor 4:5 gearing ratio to wheel

    // called when init button is  pressed.

    @Override
    public void runOpMode() throws InterruptedException
    {
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        mineralMotor = hardwareMap.get(DcMotor.class, "mineralMotor");

//        mineralArm = hardwareMap.get(Servo.class, "mineralArm");
//        mineralArm.setDirection(Servo.Direction.REVERSE);
//        mineralArm.setPosition(mineralArm_Ground);

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.REVERSE);
        mineralMotor.setDirection(DcMotor.Direction.REVERSE);


        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mineralMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        mineralMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        int leftstartpos = leftDrive.getCurrentPosition();
        int rightstartpos = rightDrive.getCurrentPosition();
        int liftStartPos = liftMotor.getCurrentPosition();
        // wait for start button.

        waitForStart();
        sleep(2000);
        telemetry.addData("Mode", "running");
        telemetry.update();

//        // set both motors to 100% power.
//
//        leftDrive.setPower(1);
//        rightDrive.setPower(1);
//
//        sleep(2000);        // wait for 2 seconds.
//
//        // set motor power to zero to stop motors.
//
//        leftDrive.setPower(0.0);
//        rightDrive.setPower(0.0);

        liftMotor.setTargetPosition(liftStartPos+3100);
        liftMotor.setPower(1);
        while (opModeIsActive() && liftMotor.isBusy());
        {
            idle();
        }
        liftMotor.setPower(0);
        telemetry.addData("Mode", "power set, lift running to postion");
        telemetry.update();
        sleep(2000);

        leftDrive.setTargetPosition(leftstartpos - 100);
        rightDrive.setTargetPosition(rightstartpos - 100);
        telemetry.addData("Run", "100"); //3.25"
        telemetry.update();

        leftDrive.setPower(-1.0);
        rightDrive.setPower(-1.0);
        telemetry.addData("Mode", "power set, drive running to postion");
        telemetry.update();

        while (opModeIsActive() && leftDrive.isBusy() && rightDrive.isBusy());
        {
            idle();
        }

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
        telemetry.addData("Mode", "stopped driving");
        telemetry.update();
    }
}