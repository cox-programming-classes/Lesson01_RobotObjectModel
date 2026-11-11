package org.firstinspires.ftc.teamcode.RobotModel.Mechs.Components;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.Extensions.GamepadExtensions;

public  class DoublyLimitedMotor extends MechComponent {

    private DcMotor motor;
    private TouchSensor forwardSensor;
    private TouchSensor reverseSensor;

    /**
     * The forward sensor is the sensor that is hit when the motor is given positive power
     * @param hardwareMap pass this down from on high
     * @param motorName name of the motor in the driver station configuration
     * @param forwardSensorName name of the forward sensor in the driver station configuration
     * @param reverseSensorName name of the reverse sensor in the driver station configuration
     */
    public DoublyLimitedMotor(
            HardwareMap hardwareMap,
            String motorName,
            String forwardSensorName,
            String reverseSensorName
            ) {
        motor = hardwareMap.get(DcMotor.class, motorName);
        forwardSensor = hardwareMap.get(TouchSensor.class, forwardSensorName);
        reverseSensor = hardwareMap.get(TouchSensor.class, reverseSensorName);
    }

    /**
     * this is a decorator method that checks to see if the motor can go forward or reverse before setting motor power
     * if the motor cannot move in that direction, it sets the power to zero
     * @param power assumes that power is between -1 and 1, and that the dead zone is applied
     */
    public void setPower(double power){

        if ((power > 0 && !canGoForward() )|| (power < 0 && !canGoReverse())) {
            power = 0;
        }

        motor.setPower(power);
    }

    @Override
    public void move(Gamepad gamepad) {
        double power = GamepadExtensions.GetLeftStickY(gamepad);
        setPower(power);
    }

    /** Writes motor power and both limit switches to telemetry. */
    @Override
    public void update()
    {
        telemetry.addData("motor power:", motor.getPower());
        telemetry.addData("can go forward:", canGoForward());
        telemetry.addData("can go reverse:", canGoReverse());
    }


    /**
     *
     * @return true if the forward sensor is not pressed
     */
    public boolean canGoForward()
    {
        return ! forwardSensor.isPressed();
    }

    /**
     *
     * @return true if the reverse sensor is not pressed
     */
    public boolean canGoReverse()
    {
        return ! reverseSensor.isPressed();
    }
}
