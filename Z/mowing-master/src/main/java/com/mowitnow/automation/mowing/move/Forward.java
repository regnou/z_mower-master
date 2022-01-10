package com.mowitnow.automation.mowing.move;

import com.mowitnow.automation.mowing.Grid;
import com.mowitnow.automation.mowing.Mower;
import com.mowitnow.automation.mowing.Position;

/**
 * Move implementation to enable mower to go forward
 */
class Forward implements Move {

    public void execute(Mower mower, Grid grid) throws UnexpectedMoveException {
        Position newPosition = mower.getPosition();
        switch (mower.getOrientation()) {
            case EAST:
                newPosition.incrementX();
                break;
            case WEST:
                newPosition.decrementX();
                break;
            case NORTH:
                newPosition.incrementY();
                break;
            case SOUTH:
                newPosition.decrementY();
                break;
        }

        if(!grid.isPositionValid(newPosition)) {
            throw new UnexpectedMoveException("Mower " + mower.getNumber() + " cannot move to this position " + newPosition.toString());
        }
        mower.setPosition(newPosition);
    }

}
