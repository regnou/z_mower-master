package com.mowitnow.automation.mowing.command.parser;

import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.command.Command;
import org.junit.Test;

import static org.junit.Assert.*;

public class MowCommandParserTest {

    @Test
    public void should_validate_mow_state() {
        String mowState = "0 2 N";
        MowerCommandParser parser = new MowerCommandParser();

        assertTrue(parser.check(new Command(mowState)));
    }

    @Test
    public void should_not_validate_mow_state_wrong_horizontal_position() {
        String mowState = "p 2 E";
        MowerCommandParser parser = new MowerCommandParser();

        assertFalse(parser.check(new Command(mowState)));
    }

    @Test
    public void should_not_validate_mow_state_missing_whitespace() {
        String mowState = "12 W";
        MowerCommandParser parser = new MowerCommandParser();

        assertFalse(parser.check(new Command(mowState)));
    }

    @Test
    public void should_not_validate_mow_state_wrong_orientation() {
        String mowState = "1 2 P";
        MowerCommandParser parser = new MowerCommandParser();

        assertFalse(parser.check(new Command(mowState)));
    }

    @Test
    public void should_not_validate_mow_state_negative_horizontal_position() {
        String mowState = "-1 2 S";
        MowerCommandParser parser = new MowerCommandParser();

        assertFalse(parser.check(new Command(mowState)));
    }

    @Test
    public void should_parse_command_to_new_mow() {
        String command = "1 2 E";
        MowerCommandParser parser = new MowerCommandParser();
        try {
            Mower mow = parser.parse(new Command(command));

            assertEquals("(1;2),E", mow.getFullPosition());

        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = ParseException.class)
    public void should_throw_parse_exception() throws ParseException {
        String command = "1 2 Z";
        new MowerCommandParser().parse(new Command(command));
    }

}
