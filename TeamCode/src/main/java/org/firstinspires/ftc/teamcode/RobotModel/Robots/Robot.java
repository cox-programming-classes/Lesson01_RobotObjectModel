package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies.MechAssembly;

import java.util.Objects;

/**
 * Abstract base for all robots in the system.
 *
 * <p>A robot has exactly one drive train, and may or may not have a mech assembly.
 *
 * @author Susan Zuo (telemetry refactor)
 */
public abstract class Robot
{
    protected final DriveTrain driveTrain;
    protected MechAssembly mechAssembly;
    protected Telemetry telemetry;

    /**
     * @param telemetry pass down from OpMode.
     * @param driveTrain this robot's one drive train.  It may not be null.
     */
    protected Robot(Telemetry telemetry, DriveTrain driveTrain)
    {
        this.telemetry = telemetry;
        this.driveTrain = Objects.requireNonNull(driveTrain, "A Robot must have a DriveTrain.");
    }

    /**
     * Hands telemetry down to the drive train and the mech assembly.
     * Call this at the end of a subclass constructor, once the mech assembly is assigned.
     */
    protected void initializeSubsystems()
    {
        driveTrain.initializeTelemetry(telemetry);
        if (mechAssembly != null) mechAssembly.initializeTelemetry(telemetry);
    }

    /**
     * Collects telemetry from every subsystem, then sends it to the Driver Station.
     * This is the only place that calls {@code telemetry.update()}.
     */
    public void updateTelemetry() {
        driveTrain.updateTelemetry();
        if (mechAssembly != null) mechAssembly.updateTelemetry();
        telemetry.update();
    }

    /**
     * update the robot state!  Pass along the gamepads to the different modules.
     * @param gamepad1 driver gamepad
     * @param gamepad2 mech gamepad
     */
    public void update(Gamepad gamepad1, Gamepad gamepad2)
    {
        driveTrain.drive(gamepad1);
        if (mechAssembly != null) mechAssembly.giveInstructions(gamepad2);
    }
}
