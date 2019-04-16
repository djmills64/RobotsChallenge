package com.robots

import com.robots.*

class RobotTest2 extends GroovyTestCase {
    void testDisplay() {
        def table = new Table()
        def robot = new Robot(table)
        robot.place(0,0,Robot.Directions.NORTH)
        robot.left()
        def expected = '0, 0, WEST'
        assertToString(robot.report(), expected)
   }
}