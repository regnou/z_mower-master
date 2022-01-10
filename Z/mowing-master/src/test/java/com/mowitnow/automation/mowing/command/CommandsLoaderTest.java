package com.mowitnow.automation.mowing.command;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.Assert.*;


public class CommandsLoaderTest {

    @Test
    public void should_load_commands_from_stream() {
        InputStream stream = this.getClass().getResourceAsStream("/data/automation.txt");
        try {
            Commands commands = CommandsLoader.load(stream);

            assertFalse(commands.isEmpty());

        } catch (CommandLoadingException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = CommandLoadingException.class)
    public void should_not_load_from_missing_file() throws CommandLoadingException {
        InputStream stream = this.getClass().getResourceAsStream("/data/missing_file.txt");
        CommandsLoader.load(stream);
    }

    @Test
    public void should_load_commands_from_instructions_list() {
        try {
            Commands commands = CommandsLoader.load(Arrays.asList("5 5", "1 2 E", "ADGDDA"));

            assertFalse(commands.isEmpty());

        } catch (CommandLoadingException e) {
            e.printStackTrace();
            fail();
        }
    }


}
