package com.mowitnow.automation.mowing.move;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RightTest {

    @Test
    public void should_turn_to_east() {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('1','2'),'N');

        Right right = new Right();
        try {
            right.execute(mow, grid);

            assertEquals("(1;2),E", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void should_turn_to_south() {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('1','2'),'E');

        Right right = new Right();
        try {
            right.execute(mow, grid);

            assertEquals("(1;2),S", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void should_turn_to_west() {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('1','2'),'S');

        Right right = new Right();
        try {
            right.execute(mow, grid);

            assertEquals("(1;2),W", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void should_turn_to_north() {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('1','2'),'W');

        Right right = new Right();
        try {
            right.execute(mow, grid);

            assertEquals("(1;2),N", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

}
