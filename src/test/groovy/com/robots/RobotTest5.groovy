package com.robots

import com.robots.*

class RobotTest5 extends GroovyTestCase {
    void testDisplay() {
        def table = new Table()
        def robot = new Robot(table)
        robot.place(3,0,Robot.Directions.EAST)
        robot.move()
        robot.move() // Will be ignored as this attempts to move off the table
        robot.left()
        robot.move()
        def expected = '4, 1, NORTH'
        assertToString(robot.report(), expected)
   }
}