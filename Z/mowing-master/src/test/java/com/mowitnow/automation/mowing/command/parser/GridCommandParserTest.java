package com.mowitnow.automation.mowing.command.parser;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.command.Command;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridCommandParserTest {

    @Test
    public void should_validate_lawn_setup() {
        String lawnSetup = "5 5";
        GridCommandParser parser = new GridCommandParser();

        assertTrue(parser.check(new Command(lawnSetup)));
    }

    @Test
    public void should_not_validate_lawn_setup_wrong_horizontal_position() {
        String lawnSetup = "p 5";
        GridCommandParser parser = new GridCommandParser();

        assertFalse(parser.check(new Command(lawnSetup)));
    }

    @Test
    public void should_not_validate_lawn_setup_missing_whitespace() {
        String lawnSetup = "55";
        GridCommandParser parser = new GridCommandParser();

        assertFalse(parser.check(new Command(lawnSetup)));
    }

    @Test
    public void should_not_validate_lawn_setup_wrong_position() {
        String lawnSetup = "-5 5";
        GridCommandParser parser = new GridCommandParser();

        assertFalse(parser.check(new Command(lawnSetup)));
    }

    @Test
    public void should_parse_command_to_new_lawn() {
        String command = "5 4";
        try {
            GridCommandParser parser = new GridCommandParser();
            Grid grid = parser.parse(new Command(command));

            assertEquals("(0;0),(5;4)", grid.toString());

        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = ParseException.class)
    public void should_throw_parse_exception() throws ParseException {
        String command = "-1 4";
        new GridCommandParser().parse(new Command(command));
    }

}
