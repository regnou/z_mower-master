package com.mowitnow.automation.mowing;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void should_return_valid_postion() {
        Grid grid = new Grid(new Position(0,0), new Position(4,5));

        assertTrue(grid.isPositionValid(new Position(1, 3)));
    }

    @Test
    public void should_return_invalid_position_x() {
        Grid grid = new Grid(new Position(0,0), new Position(4,5));

        assertFalse(grid.isPositionValid(new Position(7, 3)));
    }

    @Test
    public void should_return_invalid_position_y() {
        Grid grid = new Grid(new Position(0,0), new Position(4,5));

        assertFalse(grid.isPositionValid(new Position(1, 9)));
    }

    @Test
    public void should_return_invalid_position_xy() {
        Grid grid = new Grid(new Position(0,0), new Position(4,5));

        assertFalse(grid.isPositionValid(new Position(7, 9)));
    }

}
