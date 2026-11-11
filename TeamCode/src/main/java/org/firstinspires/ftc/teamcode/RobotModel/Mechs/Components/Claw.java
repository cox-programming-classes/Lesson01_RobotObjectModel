package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw extends MechComponent
{
    // TODO: the claw is running blind. A CRServo has no notion of position, so right now
    //  nothing in this class can answer either of the two questions a driver actually
    //  cares about: "is it fully closed?" and "am I holding something?"
    //
    //  Two different sensors, answering two different questions - decide which this
    //  season's claw needs before wiring anything:
    //    - Travel limits. Two TouchSensors at fully-open and fully-closed, enforced the
    //      way DoublyLimitedMotor enforces a motor's limits. This stops the servo
    //      straining against a hard stop, which is what burns them out.
    //    - A grip sensor. One TouchSensor on the jaw, or a DistanceSensor or color
    //      sensor looking into the grip, answering "is there a game piece in there?"
    public CRServo servo;

    public Claw(HardwareMap hardwareMap,
                String servoName)
    {
        servo = hardwareMap.get(CRServo.class, servoName);
    }

    @Override
    public void move(Gamepad gamepad)
    {
        if(gamepad.left_bumper)
            servo.setPower(1);
        else if(gamepad.right_bumper)
            servo.setPower(-1);
        else
            servo.setPower(0);
    }

    /** Writes the claw's power to telemetry. */
    @Override
    public void update()
    {
        telemetry.addData("Claw power:", servo.getPower());
    }

}
