package com.robots

import com.robots.*

class RobotTest1 extends GroovyTestCase {
    void testDisplay() {
        def table = new Table()
        def robot = new Robot(table)
        robot.place(0,0,Robot.Directions.NORTH)
        robot.move()
        def expected = '0, 1, NORTH'
        assertToString(robot.report(), expected)
   }
}