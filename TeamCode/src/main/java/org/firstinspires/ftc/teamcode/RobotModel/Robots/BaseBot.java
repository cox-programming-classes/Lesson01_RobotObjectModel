package org.firstinspires.ftc.teamcode.RobotModel.Robots;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotModel.DriveTrain.DriveTrain;
import org.firstinspires.ftc.teamcode.RobotModel.Mechs.Assemblies.Arm;

public class BaseBot extends Robot
{
    /**
     * @param hardwareMap pass down from OpMode.
     * @param telemetry pass down from OpMode.
     * @param driveTrain any DriveTrain.
     */
    public BaseBot(HardwareMap hardwareMap, Telemetry telemetry, DriveTrain driveTrain)
    {
        super(telemetry, driveTrain);
        mechAssembly = new Arm(hardwareMap);
        initializeSubsystems();
    }
}
