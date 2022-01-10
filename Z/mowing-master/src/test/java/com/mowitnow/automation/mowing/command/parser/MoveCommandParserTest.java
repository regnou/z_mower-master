package com.mowitnow.automation.mowing.command.parser;

import com.mowitnow.automation.mowing.command.Command;
import com.mowitnow.automation.mowing.move.Move;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MoveCommandParserTest {

    @Test
    public void should_validate_moves() {
        String moves = "ADAAGDA";
        MoveCommandParser parser = new MoveCommandParser();

        assertTrue(parser.check(new Command(moves)));
    }

    @Test
    public void should_not_validate_move_invalid_B_instruction() {
        String moves = "ADBAGDA";
        MoveCommandParser parser = new MoveCommandParser();

        assertFalse(parser.check(new Command(moves)));
    }

    @Test
    public void should_parse_command_to_moves() {
        String command = "ADG";
        MoveCommandParser parser = new MoveCommandParser();
        try {
            List<Move> moves = parser.parse(new Command(command));

            assertEquals(3, moves.size());

        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = ParseException.class)
    public void shuld_throw_parse_exception() throws ParseException {
        String command = "ZAG";
        new MoveCommandParser().parse(new Command(command));
    }

}
