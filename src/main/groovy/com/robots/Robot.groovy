package com.robots

import com.robots.Table

class Robot {
    // Restrict the facing direction to the 4 possibilities and "name" them
    enum Directions {
        NORTH, EAST, SOUTH, WEST
    }
    
    private Table table
    private boolean onTable
    private int xPos
    private int yPos
    private Directions facing

    // Require a table (which will default to 5x5) as argument
    Robot(Table t) {
        table = t
        onTable = false
    }

    void place(int x, int y, dir) {
        // Make sure we're not trying to place off the board
        assert x >= 0 && y >= 0
        if (x >= table.getWidth() || y >= table.getLength()) {
            println("Cannot place the robot off the table, $x, $y " + table.getWidth() + " " + table.getLength())
            return
        }
        xPos = x
        yPos = y
        facing = dir as Directions
        onTable = true
    }

    void move() {
        if (!onTable) {
            // Not on the table yet - ignore the command
            return
        }
        switch(facing) {
            case Directions.NORTH:
                if (yPos + 1 == table.getLength()) {
                    println("Cannot move the robot off the table")
                    return
                }
                yPos++
                break
            case Directions.EAST:
                if (xPos + 1 == table.getWidth()) {
                    println("Cannot move the robot off the table")
                    return
                }
                xPos++
                break
            case Directions.SOUTH:
                if (yPos == 0) {
                    println("Cannot move the robot off the table")
                    return
                }
                yPos--
                break
            case Directions.WEST:
                if (xPos == 0) {
                    println("Cannot move the robot off the table")
                    return
                }
                xPos--
                break
        }
    }

    void left() {
        if (!onTable) {
            // Not on the table yet - ignore the command
            return
        }
        facing = facing.previous()
    }

    void right() {
        if (!onTable) {
            // Not on the table yet - ignore the command
            return
        }
        facing = facing.next()
    }

    String report() {
        if (!onTable) {
            println("Not yet on the table - cannot report")
        }
        String report = "$xPos, $yPos, $facing"
        println(report)
        report
    }
}
