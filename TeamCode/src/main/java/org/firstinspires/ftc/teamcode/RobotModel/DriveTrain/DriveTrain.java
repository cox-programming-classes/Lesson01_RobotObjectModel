package org.firstinspires.ftc.teamcode.RobotModel.DriveTrain;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Abstract base for all drive train implementations.
 *
 * @author Susan Zuo (telemetry refactor)
 */
public abstract class DriveTrain
{
    public abstract void drive(Gamepad gamepad);

    protected Telemetry telemetry;

    /** Stores the telemetry reference.  Called once, by the Robot. */
    public abstract void initializeTelemetry(Telemetry telemetry);

    /** Writes this drive train's readout to telemetry. */
    public abstract void updateTelemetry();
}
