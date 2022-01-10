package com.mowitnow.automation.mowing.command;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CommandsTest {

    @Test
    public void should_fill_commands_list() {
        List<String> instructions = Arrays.asList("5 5", "1 2 E", "ADGGDDA");
        Commands commands = new Commands(instructions);

        assertEquals(3, commands.size());
    }

    @Test
    public void should_get_grid_setup() {
        List<String> instructions = Arrays.asList("5 5", "1 2 E");
        Commands commands = new Commands(instructions);

        assertEquals("5 5", commands.getGridSetup().toString());
    }

    @Test
    public void should_get_second_mow_configuration() {
        List<String> instructions = Arrays.asList("5 5", "1 2 E", "ADGGDDA", "5 4 N", "GGDAADG");
        Commands commands = new Commands(instructions);

        // first mow configuration
        commands.nextMowSetup();
        commands.nextMowMoves();

        // second mow configuration
        assertEquals("5 4 N", commands.nextMowSetup().toString());
        assertEquals("GGDAADG", commands.nextMowMoves().toString());
    }

}
