package com.mowitnow.automation.mowing.command.parser;

import com.mowitnow.automation.mowing.command.Command;
import com.mowitnow.automation.mowing.move.Move;
import com.mowitnow.automation.mowing.move.MoveFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Command parser implementation for mower move
 */
public class MoveCommandParser implements CommandParser<List<Move>> {

    public List<Move> parse(Command command) throws ParseException {
        if(!check(command)) {
            throw new ParseException("Invalid movement command: " + command.toString());
        }

        char[] characters = command.toString().toCharArray();
        List<Move> movements = new ArrayList<Move>(characters.length);
        for(char character : characters) {
            movements.add(MoveFactory.getMove(character));
        }
        return movements;
    }

    public boolean check(Command command) {
        if(null == command || null == command.toString()) {
            return false;
        }
        return command.toString().matches("^[ADG]*$");
    }

}
