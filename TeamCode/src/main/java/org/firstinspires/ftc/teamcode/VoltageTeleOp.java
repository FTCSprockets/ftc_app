package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Benla on 11/9/2018.
 */

@TeleOp (group = "Voltage", name = "TeleOp") //this is a thing that lets you see the OpMode from the phone.
                                                // Teleops have the @TeleOp annotation
                                                //Autonomous has the @Autonomous annotation
                                                //Classes you don't want to show up on the driver's station, such as base support classes, annotate with @Disabled
public class VoltageTeleOp extends VoltageBase
{
    @Override
    public void DefineOpMode ()
    {
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setPower(1);

        mineralArm.setPosition(mineralArm_Ground);
        waitForStart();

        int liftStartPosition = liftMotor.getCurrentPosition();
        telemetry.addData("Start Position", liftStartPosition);
        telemetry.update();

        while (opModeIsActive())
        {
            //Tank Drive
            leftDrive.setPower(-gamepad1.left_stick_y/2);
            rightDrive.setPower(-gamepad1.right_stick_y/2);


            // Mineral arm servo movement
            if(gamepad2.x) {
                mineralArm.setPosition(mineralArm_Dump);
                telemetry.addData("Servo Position", mineralArm.getPosition());
                telemetry.update();
            }
            if (gamepad2.y) {
                mineralArm.setPosition(mineralArm_Raised);
                telemetry.addData("Servo Position", mineralArm.getPosition());
                telemetry.update();
            }
            if (gamepad2.b) {
                mineralArm.setPosition(mineralArm_Low);  // Set the servo to the new position
                telemetry.addData("Servo Position", mineralArm.getPosition());
                telemetry.update();
            }
            if (gamepad2.a) {
                mineralArm.setPosition(mineralArm_Ground);  // Set the servo to the new position
                telemetry.addData("Servo Position", mineralArm.getPosition());
                telemetry.update();
            }

            //Hook attachment in End Game
            telemetry.addData("Lift Motor Position", liftMotor.getCurrentPosition());
            telemetry.update();
            if (!gamepad2.right_bumper) {
                if (liftMotor.getCurrentPosition() > liftStartPosition - 100 && liftMotor.getTargetPosition() < liftStartPosition + HD_EncoderExtendedPosition + 100) {
                    if (gamepad2.dpad_up) {
                        liftMotor.setTargetPosition(liftMotor.getCurrentPosition() + 50);
                    } else if (gamepad2.dpad_down) {
                        liftMotor.setTargetPosition(liftMotor.getCurrentPosition() - 50);
                    }
                } else if (liftMotor.getCurrentPosition() <= liftStartPosition - 100) {
                    liftMotor.setTargetPosition(liftStartPosition);
                } else if (liftMotor.getCurrentPosition() >= liftStartPosition + HD_EncoderExtendedPosition + 100) {
                    liftMotor.setTargetPosition(liftStartPosition + HD_EncoderExtendedPosition);
                }
            } else {
                if (gamepad2.dpad_up) {
                    liftMotor.setTargetPosition(liftMotor.getCurrentPosition() + 50);
                } else if (gamepad2.dpad_down) {
                    liftMotor.setTargetPosition(liftMotor.getCurrentPosition() - 50);
                }
                liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            telemetry.addData("Target Position", liftMotor.getTargetPosition());
            telemetry.update();

            //Backup hook attachment
            if (gamepad2.dpad_left) {
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition()-50);
            }
            if (gamepad2.dpad_right) {
                liftMotor.setTargetPosition(liftMotor.getCurrentPosition()+50);
            }
        }

//            //Hook attachment movement
//            if(gamepad2.left_bumper) {
//                completeHookContract(0.8);
//            }
//
//            else if(gamepad2.right_bumper) {
//                completeHookExtend(0.8, stringInches);
//            }

            idle(); //put this at the end of larger while loops to let the software catch up with itself.
        }
    }

