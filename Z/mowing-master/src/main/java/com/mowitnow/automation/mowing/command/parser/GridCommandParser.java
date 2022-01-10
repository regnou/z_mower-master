package com.mowitnow.automation.mowing.command.parser;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.command.Command;
import com.mowitnow.automation.mowing.Position;

/**
 * Command parser implementation for grid
 */
public class GridCommandParser implements CommandParser<Grid> {

    public Grid parse(Command command) throws ParseException {
        if(!check(command)) {
            throw new ParseException("Invalid grid setup command: " + command.toString());
        }

        char[] characters = command.toString().toCharArray();
        Position originGridPosition = new Position(0, 0);
        Position endGridPosition = new Position(characters[0], characters[2]);
        return new Grid(originGridPosition, endGridPosition);
    }

    public boolean check(Command command) {
        if(null == command || null == command.toString()) {
            return false;
        }
        return command.toString().matches("^\\d+\\s\\d+$");
    }

}
