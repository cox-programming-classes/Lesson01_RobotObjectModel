package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Base class for every mechanism component on the robot.
 *
 * <p><b>What belongs in a component.</b> Every concrete MechComponent should be
 * exactly one of two things:
 *
 * <ol>
 *   <li><b>A wrapper around a single output device</b> - one motor, one servo,
 *       one CR servo. The class adds its controls and telemetry, and nothing
 *       else. We need exactly <em>one</em> of these per device type, and it
 *       should be named for the <em>device</em>, since any mechanism built on
 *       that device reuses it as-is.</li>
 *   <li><b>A purposeful collection of output devices plus the sensors that
 *       guide them</b> - a motor bounded by two limit switches, two motors
 *       driven as an opposed pair, a camera and the processors reading it.
 *       These are named for what the collection <em>does</em>, because the
 *       coupling between the outputs and the sensors is the whole point.</li>
 * </ol>
 *
 * <p>A class that is neither - a second single-device wrapper named after one
 * robot's job for it - is duplication, and every fix to one is a fix owed to
 * the other.
 *
 * @author Susan Zuo (telemetry refactor)
 */
public abstract class MechComponent
{
    protected interface IControlStrategy { }

    protected Telemetry telemetry;

    /** Stores the telemetry reference.  Called once, by the assembly that owns this component. */
    public void initializeTelemetry(Telemetry telemetry)
    {
        this.telemetry = telemetry;
    }

    public abstract void move(Gamepad gamepad);

    /** Writes this component's readout to telemetry. */
    public abstract void update();
}
