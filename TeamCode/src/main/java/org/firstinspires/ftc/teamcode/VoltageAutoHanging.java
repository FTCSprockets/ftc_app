package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Hanging", group="Autonomous")
public class VoltageAutoHanging extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();
    //Declare Motors
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor liftMotor;

    //Declare Servos
    public Servo mineralArm;

    // called when init button is  pressed.

    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");

        mineralArm = hardwareMap.get(Servo.class, "mineralArm");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.REVERSE);

        mineralArm.setDirection(Servo.Direction.REVERSE);

        mineralArm.setPosition(0.0);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

//        // set both motors to 25% power.
//        leftDrive.setPower(-0.25);
//        rightDrive.setPower(-0.25);

        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setPower(1);

        //extend hook
        int liftStartPosition = liftMotor.getCurrentPosition();
        liftMotor.setTargetPosition(liftMotor.getCurrentPosition() - 3100);

        sleep(2000);        // wait for 2 seconds.

        //move backwards
        leftDrive.setPower(-0.25);
        rightDrive.setPower(-0.25);

        /*
        extends hook
        thendrivesnbackwards 4 inches
        lower hook to starting position

        */
         liftStartPosition = liftMotor.getCurrentPosition();

        // set motor power to zero to stop motors.

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
    }
}
