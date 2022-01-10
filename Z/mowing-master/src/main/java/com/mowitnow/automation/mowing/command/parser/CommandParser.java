package com.mowitnow.automation.mowing.command.parser;

import com.mowitnow.automation.mowing.command.Command;

/**
 * Command parser interface
 *
 * @param <T>
 */
public interface CommandParser<T> {

    /**
     * Parse a command into an object
     *
     * @param command to parse
     * @return the object created from command
     * @throws ParseException
     */
    T parse(Command command) throws ParseException;

    /**
     * Check command validity
     *
     * @param command to check
     * @return boolean
     */
    boolean check(Command command);

}
