package com.mowitnow.automation.mowing.move;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForwardTest {

    @Test
    public void should_go_forward_north() {
        Grid grid = new Grid(new Position(0,0), new Position(3,3));
        Mower mow = new Mower(new Position('1','2'),'N');

        Forward forward = new Forward();
        try {
            forward.execute(mow, grid);

            assertEquals("(1;3),N", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void should_go_forward_east() {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('1','2'),'E');

        Forward forward = new Forward();
        try {
            forward.execute(mow, grid);

            assertEquals("(2;2),E", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void should_go_forward_south() {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('1','2'),'S');

        Forward forward = new Forward();
        try {
            forward.execute(mow, grid);

            assertEquals("(1;1),S", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void should_go_forward_west() {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('1','2'),'W');

        Forward forward = new Forward();
        try {
            forward.execute(mow, grid);

            assertEquals("(0;2),W", mow.getFullPosition());

        } catch (UnexpectedMoveException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(expected = UnexpectedMoveException.class)
    public void should_throw_unexpected_move_exception() throws UnexpectedMoveException {
        Grid grid = new Grid(new Position(0,0), new Position(2,2));
        Mower mow = new Mower(new Position('0','1'),'W');

        Forward forward = new Forward();
        forward.execute(mow, grid);
    }

}
