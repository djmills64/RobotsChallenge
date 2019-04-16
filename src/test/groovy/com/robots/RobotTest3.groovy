package com.robots

import com.robots.*

class RobotTest3 extends GroovyTestCase {
    void testDisplay() {
        def table = new Table()
        def robot = new Robot(table)
        robot.place(1,2,Robot.Directions.EAST)
        robot.move()
        robot.move()
        robot.left()
        robot.move()
        def expected = '3, 3, NORTH'
        assertToString(robot.report(), expected)
   }
}