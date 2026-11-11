package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies.MechAssembly;

/**
 * Abstract base for all robots in the system.
 *
 * @author Susan Zuo (telemetry refactor)
 */
public abstract class Robot
{
    protected DriveTrain driveTrain;
    protected MechAssembly mechAssembly;
    protected Telemetry telemetry;

    protected Robot(Telemetry telemetry)
    {
        this.telemetry = telemetry;
    }

    /**
     * Hands telemetry down to the drive train and the mech assembly.
     * Call this at the end of a subclass constructor, once both are assigned.
     */
    protected void initializeSubsystems()
    {
        if (driveTrain != null) driveTrain.initializeTelemetry(telemetry);
        if (mechAssembly != null) mechAssembly.initializeTelemetry(telemetry);
    }

    /**
     * Collects telemetry from every subsystem, then sends it to the Driver Station.
     * This is the only place that calls {@code telemetry.update()}.
     */
    public void updateTelemetry() {
        if (driveTrain != null) driveTrain.updateTelemetry();
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
        if (driveTrain != null) driveTrain.drive(gamepad1);
        if (mechAssembly != null) mechAssembly.giveInstructions(gamepad2);
    }
}
