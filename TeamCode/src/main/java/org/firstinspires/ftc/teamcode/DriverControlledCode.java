package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "14321 Teleop" , group = "Main")

public class DriverControlledCode extends LinearOpMode
{

    public DcMotor topRightMotor;
    public DcMotor topLeftMotor;
    public DcMotor bottomRightMotor;
    public DcMotor bottomLeftMotor;
    private HardwareMap hardwareMap = null;
    public ElapsedTime runTime = new ElapsedTime();
    double horizontal;
    double vertical;
    double rotationalx;

    @Override

    public void runOpMode()
    {

        topLeftMotor = hardwareMap.get(DcMotor.class, "topLeftMotor");
        topRightMotor = hardwareMap.get(DcMotor.class, "topRightMotor");
        bottomLeftMotor = hardwareMap.get(DcMotor.class, "bottomLeftMotor");
        bottomRightMotor = hardwareMap.get(DcMotor.class, "bottomRightMotor");

        topLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        topLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        topRightMotor.setDirection(DcMotor.Direction.REVERSE);
        bottomRightMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive())
        {

            horizontal = gamepad1.left_stick_x;
            vertical = -gamepad1.left_stick_y;
            rotationalx = gamepad1.right_stick_x;

            topLeftMotor.setPower(vertical + horizontal + rotationalx);
            topRightMotor.setPower(vertical - horizontal - rotationalx);
            bottomRightMotor.setPower(vertical + horizontal - rotationalx);
            bottomLeftMotor.setPower(vertical - horizontal + rotationalx);


        }
    }


}
