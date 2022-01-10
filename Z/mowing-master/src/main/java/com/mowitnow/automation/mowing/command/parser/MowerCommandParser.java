package com.mowitnow.automation.mowing.command.parser;

import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.Position;
import com.mowitnow.automation.mowing.command.Command;

/**
 * Command parser implementation for mower
 */
public class MowerCommandParser implements CommandParser<Mower> {

    public Mower parse(Command command) throws ParseException {
        if(!check(command)) {
            throw new ParseException("Invalid mow setup command: " + command.toString());
        }
        char[] characters = command.toString().toCharArray();
        Position initialPosition = new Position(characters[0], characters[2]);
        return new Mower(initialPosition, characters[4]);
    }

    public boolean check(Command command) {
        if(null == command || null == command.toString()) {
            return false;
        }
        return command.toString().matches("^\\d+\\s\\d+\\s[NEWS]$");
    }

}
