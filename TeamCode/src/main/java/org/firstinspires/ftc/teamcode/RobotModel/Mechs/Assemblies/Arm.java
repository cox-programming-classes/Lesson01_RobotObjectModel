package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components.Claw;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components.DoublyLimitedMotor;

public class Arm extends MechAssembly
{
    private final DoublyLimitedMotor lift;
    private final Claw claw;

    public Arm(HardwareMap hardwareMap)
    {
        lift = new DoublyLimitedMotor(
                hardwareMap,
                "cascadeMotor",
                "topLiftLimit",
                "bottomLiftLimit");
        claw = new Claw(hardwareMap, "claw");
    }

    @Override
    public void initializeTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
        lift.initializeTelemetry(telemetry);
        claw.initializeTelemetry(telemetry);
    }

    @Override
    public void giveInstructions(Gamepad gamepad) {
        lift.move(gamepad);
        claw.move(gamepad);
    }

    @Override
    public void updateTelemetry() {
        telemetry.addLine("--- Arm ---");
        lift.update();
        claw.update();
    }
}
