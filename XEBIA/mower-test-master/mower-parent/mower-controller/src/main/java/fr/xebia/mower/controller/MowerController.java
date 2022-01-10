package fr.xebia.mower.controller;

import java.awt.Point;
import java.util.Collection;

import fr.xebia.mower.core.Direction;
import fr.xebia.mower.core.Grid;
import fr.xebia.mower.core.Mower;
import fr.xebia.mower.core.MowerState;

public class MowerController {

    private final Grid grid;
    private final Mower mower;

    public MowerController(Grid grid) {
        this(grid, new Point(0, 0), Direction.NORTH);
    }

    public MowerController(Grid grid, MowerState state) {
        this(grid, state.getPosition(), state.getDirection());
    }

    public MowerController(Grid grid, Point initialMowerPosition) {
        this(grid, initialMowerPosition, Direction.NORTH);
    }

    public MowerController(Grid grid, Point initialMowerPosition, Direction initialMowerDirection) {
        if (grid == null) {
            throw new IllegalArgumentException("The grid must not be null");
        }
        if (initialMowerPosition == null) {
            throw new IllegalArgumentException("The initial position must not be null");
        }
        this.grid = grid;
        this.mower = new Mower(initialMowerPosition, initialMowerDirection);
    }

    public MowerState getCurrentMowerState() {
        return mower.getCurrentMowerState();
    }

    public Point getCurrentMowerPosition() {
        return mower.getCurrentPosition();
    }

    public Direction getCurrentMowerDirection() {
        return mower.getCurrentDirection();
    }

    public void performAction(Action action) {
        if (action == null) {
            throw new IllegalArgumentException("The action must not be null");
        }
        Direction currentDirection = mower.getCurrentDirection();
        Point currentPosition = mower.getCurrentPosition();
        Direction newDirection = currentDirection;
        Point newPosition = currentPosition;
        switch (action) {
        case ROTATE_CLOCKWISE:
            newDirection = Direction.getNextClockwiseDirection(currentDirection);
            break;
        case ROTATE_COUNTERCLOCKWISE:
            newDirection = Direction.getNextCounterClockwiseDirection(currentDirection);
            break;
        case MOVE_FORWARD:
            Point nextPosition = Direction.getNextPoint(currentDirection, currentPosition);
            if (grid.isWithinBounds(nextPosition)) {
                newPosition = nextPosition;
            }
            break;
        }
        mower.setDirection(newDirection);
        mower.setPosition(newPosition);
    }

    public void performActions(Collection<Action> actions) {
        if (actions == null) {
            throw new IllegalArgumentException("The actions collection must not be null");
        }
        for (Action action : actions) {
            performAction(action);
        }
    }

}
