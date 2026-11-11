package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Composite of all mech components on the robot. Inheritors hold discrete
 * {@link org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components.MechComponent}
 * implementations and delegate instructions to them.
 *
 * @author Susan Zuo (telemetry refactor)
 */
public abstract class MechAssembly
{
    /**
     * Pass along gamepad instructions to subcomponents.
     * @param gamepad the Gamepad
     */
    public abstract void giveInstructions(Gamepad gamepad);

    protected Telemetry telemetry;

    /** Stores the telemetry reference and hands it to every component.  Called once, by the Robot. */
    public abstract void initializeTelemetry(Telemetry telemetry);

    /** Writes the readout of every component to telemetry. */
    public abstract void updateTelemetry();
}
