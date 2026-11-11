# Lesson 1 - The Robot Object Model

*Placeholder.  The lesson text gets written with Jason.*

The base bot:  a tank drive, and an arm with one lift and a claw.  Every
component defines its own controls in its `move(gamepad)` method.

| Piece | Class |
|---|---|
| Robot | `BaseBot` |
| Drive train | `StandardTankDrive` or `OneStickTank` |
| Mech assembly | `Arm`:  one `DoublyLimitedMotor` and one `Claw` |
| OpModes | `Base Bot (Standard Tank)`, `Base Bot (One Stick)` |

The two OpModes build the same `BaseBot`, and differ in one line:  the drive
train each one hands it.

Hardware configuration names:  `leftTread`, `rightTread`, `cascadeMotor`,
`topLiftLimit`, `bottomLiftLimit`, `claw`.

The code lives in `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/`.
Open the project folder in Android Studio and deploy to a robot the usual way.

## License

The course materials here are licensed under [Creative Commons
Attribution-NonCommercial-ShareAlike 4.0
International](https://creativecommons.org/licenses/by-nc-sa/4.0/) (CC BY-NC-SA
4.0).  The full text is in [`LICENSE`](LICENSE).  The FTC SDK
(`FtcRobotController/`, the Gradle build, and `libs/`) keeps its license from
*FIRST*, in [`LICENSE-FIRST`](LICENSE-FIRST).
