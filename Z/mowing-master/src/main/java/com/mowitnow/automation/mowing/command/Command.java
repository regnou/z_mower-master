package com.mowitnow.automation.mowing.command;

/**
 * Define a command
 *
 * A command is a string that configure/setup the program automation objects
 */
public class Command {

    private String cmd;

    public Command(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return cmd;
    }
}
