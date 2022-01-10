package com.mowitnow.automation.mowing.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Define the object that enables commands loading from several inputs
 */
public class CommandsLoader {

    /**
     * Load commands from a file
     *
     * @param file
     * @return the commands
     * @throws CommandLoadingException
     */
    public static Commands load(File file) throws CommandLoadingException {
        try {
            return load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new CommandLoadingException(e);
        }
    }

    /**
     * Load commands from stream
     *
     * @param stream
     * @return the commands
     * @throws CommandLoadingException
     */
    public static Commands load(InputStream stream) throws CommandLoadingException {
        if(null == stream) {
            throw new CommandLoadingException("No content to load");
        }
        List<String> lines = new ArrayList<String>();
        Scanner scanner = new Scanner(stream);
        while(scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return load(lines);
    }

    /**
     * Load commands from a list of strings
     *
     * @param instructions
     * @return the commands
     * @throws CommandLoadingException
     */
    public static Commands load(List<String> instructions) throws CommandLoadingException {
        return new Commands(instructions);
    }

}
