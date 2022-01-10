package com.mowitnow.automation.mowing.move;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.Mower;

/**
 * Mower move interface
 */
public interface Move {

    /**
     * Execute the right move for the given mower on the grid
     *
     * @param mower
     * @param grid
     * @throws UnexpectedMoveException
     */
    void execute(Mower mower, Grid grid) throws UnexpectedMoveException;

}
