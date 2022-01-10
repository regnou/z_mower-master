package com.mowitnow.automation.mowing.move;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.Orientation;

/**
 * Move implementation to enable mower to turn left
 */
class Left implements Move {

    public void execute(Mower mower, Grid grid) throws UnexpectedMoveException {
        Orientation newOrientation = null;
        switch (mower.getOrientation()) {
            case EAST:
                newOrientation = Orientation.NORTH;
                break;
            case WEST:
                newOrientation = Orientation.SOUTH;
                break;
            case NORTH:
                newOrientation = Orientation.WEST;
                break;
            case SOUTH:
                newOrientation = Orientation.EAST;
                break;
        }
        mower.setOrientation(newOrientation);
    }

}
