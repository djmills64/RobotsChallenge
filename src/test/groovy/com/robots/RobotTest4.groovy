package com.robots

import com.robots.*

class RobotTest4 extends GroovyTestCase {
    void testDisplay() {
        def table = new Table()
        def robot = new Robot(table)
        robot.place(4,4,Robot.Directions.EAST)
        robot.move()
        robot.right()
        robot.move()
        robot.move()
        robot.right()
        robot.move()
        def expected = '3, 2, WEST'
        assertToString(robot.report(), expected)
   }
}