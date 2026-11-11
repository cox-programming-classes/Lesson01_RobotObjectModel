package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.Tank.StandardTankDrive;
import org.firstinspires.ftc.teamcode.RobotModel.Robots.BaseBot;
import org.firstinspires.ftc.teamcode.RobotModel.Robots.Robot;

/**
 * The smallest complete OpMode in the project: build a Robot, then loop.
 *
 * <p>Every OpMode in this codebase has the same four steps — construct the robot,
 * {@code waitForStart()}, then {@code update()} + {@code updateTelemetry()} until the
 * driver stops it. Everything that makes one robot different from another lives in the
 * {@code RobotModel}, not here.
 */
@TeleOp(name = "Base Bot (Standard Tank)", group = "Base Bot")
public class BaseBotStandardTankTeleOp extends LinearOpMode
{
    Robot robot;

    @Override
    public void runOpMode() throws InterruptedException
    {
        robot = new BaseBot(hardwareMap, telemetry, new StandardTankDrive(hardwareMap));

        telemetry.addLine("initialized");
        telemetry.update();

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive())
        {
            robot.update(gamepad1, gamepad2);
            robot.updateTelemetry();
        }
    }
}
