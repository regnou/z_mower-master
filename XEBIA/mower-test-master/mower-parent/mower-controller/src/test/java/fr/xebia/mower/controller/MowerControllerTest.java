package fr.xebia.mower.controller;

import static fr.xebia.mower.controller.Action.MOVE_FORWARD;
import static fr.xebia.mower.controller.Action.ROTATE_CLOCKWISE;
import static fr.xebia.mower.controller.Action.ROTATE_COUNTERCLOCKWISE;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import fr.xebia.mower.core.Direction;
import fr.xebia.mower.core.Grid;

public class MowerControllerTest {

    private void performActionsTest(MowerController controller, Collection<Action> actions, Point expectedPosition,
            Direction expectedDirection) {
        controller.performActions(actions);
        assertTrue(controller.getCurrentMowerPosition().equals(expectedPosition));
        assertTrue(controller.getCurrentMowerDirection().equals(expectedDirection));
    }

    @Test
    public void performSimpleControllerTest1() {
        Grid grid = new Grid(5, 5);
        Point initialPosition = new Point(1, 2);
        Direction initialDirection = Direction.NORTH;
        MowerController controller = new MowerController(grid, initialPosition, initialDirection);
        // GAGAGAGAA
        List<Action> actions = Arrays.asList(ROTATE_COUNTERCLOCKWISE, MOVE_FORWARD, ROTATE_COUNTERCLOCKWISE,
                MOVE_FORWARD, ROTATE_COUNTERCLOCKWISE, MOVE_FORWARD, ROTATE_COUNTERCLOCKWISE, MOVE_FORWARD,
                MOVE_FORWARD);
        Point expectedPosition = new Point(1, 3);
        Direction expectedDirection = Direction.NORTH;
        performActionsTest(controller, actions, expectedPosition, expectedDirection);
    }

    @Test
    public void performSimpleControllerTest2() {
        Grid grid = new Grid(5, 5);
        Point initialPosition = new Point(3, 3);
        Direction initialDirection = Direction.EAST;
        MowerController controller = new MowerController(grid, initialPosition, initialDirection);
        // AADAADADDA
        List<Action> actions = Arrays.asList(MOVE_FORWARD, MOVE_FORWARD, ROTATE_CLOCKWISE, MOVE_FORWARD, MOVE_FORWARD,
                ROTATE_CLOCKWISE, MOVE_FORWARD, ROTATE_CLOCKWISE, ROTATE_CLOCKWISE, MOVE_FORWARD);
        Point expectedPosition = new Point(5, 1);
        Direction expectedDirection = Direction.EAST;
        performActionsTest(controller, actions, expectedPosition, expectedDirection);
    }

}
