package com.mowitnow.automation.mowing.move;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.Orientation;

/**
 * Move implementation to enable mower to turn right
 */
class Right implements Move {

    public void execute(Mower mower, Grid grid) throws UnexpectedMoveException {
        Orientation newOrientation = null;
        switch (mower.getOrientation()) {
            case EAST:
                newOrientation = Orientation.SOUTH;
                break;
            case WEST:
                newOrientation = Orientation.NORTH;
                break;
            case NORTH:
                newOrientation = Orientation.EAST;
                break;
            case SOUTH:
                newOrientation = Orientation.WEST;
                break;
        }
        mower.setOrientation(newOrientation);
    }
}
