package com.robots

import com.robots.Robot
import com.robots.Table

// The -c or --command-file-name option is required.  Can be passed via gradle using
// "gradle -Pcommand-file-name=commands"
def cli = new CliBuilder(usage:'RobotRun.groovy')
cli.c(longOpt: 'command-file-name', args:1, argName:'commandFileName', 'File name of the file containing the commands to run', required: true)

def options = cli.parse(args)
if(!options){
    throw new Exception("Invalid arguments received")
}

String commandFileName = options.c

Table table = new Table()
Robot robot = new Robot(table)

// Open and read the commands file specified on the command line
File commandFile
def lines
try {
    commandFile = new File(commandFileName)
    lines = commandFile.readLines()
} catch (Exception e) {
    println("File $commandFileName doesn't exist")
    return 1
}

// May not be considered an error to have an empty commands file
assert lines.size() > 0

// Parse each command and action it
for (line in lines) {
    def tokens = line.tokenize(" ")
    def placeArgs
    switch(tokens[0]) {
        case "PLACE":
            if (tokens.size() != 2) {
                println("Wrong number of args for PLACE command")
                break
            }

            // Parse the 3 "place" arguments
            placeArgs = tokens[1].tokenize(",")
            if (placeArgs.size() != 3) {
                println("Wrong number of args for PLACE command")
                break
            }
            robot.place(placeArgs[0].toInteger(), placeArgs[1].toInteger(), placeArgs[2])
            break
        case "MOVE":
            robot.move()
            break
        case "LEFT":
            robot.left()
            break
        case "RIGHT":
            robot.right()
            break
        case "REPORT":
            robot.report()
            break
        case null:
            // Blank line - do nothing
            break
        default:
            println("Command " + tokens[0] + " not known")
            break
    }
}
