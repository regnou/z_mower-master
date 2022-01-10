package fr.xebia.mower.operator;

import static fr.xebia.mower.controller.Action.MOVE_FORWARD;
import static fr.xebia.mower.controller.Action.ROTATE_CLOCKWISE;
import static fr.xebia.mower.controller.Action.ROTATE_COUNTERCLOCKWISE;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import fr.xebia.mower.controller.Action;
import fr.xebia.mower.core.Direction;
import fr.xebia.mower.core.Grid;
import fr.xebia.mower.core.MowerState;

public class MowerOperatorSpecSerializerTest {

    private static final String TEST1_IN_FILENAME = "serialization1_in.txt";

    @Test
    public void serializationTest1() throws IOException {
        try (InputStream in = getClass().getResourceAsStream("/" + TEST1_IN_FILENAME)) {

            MowerOperatorSpecSerializer serializer = new MowerOperatorSpecSerializer(
                    ActionLabelTranslator.FRENCH_LABEL_TRANSLATOR);
            MowerOperatorSpec operatorSpec = serializer.deSerialize(in);
            Grid expectedGrid = new Grid(5, 5);
            Collection<MowerInstructionsSpec> mowerInstructionsSpecs = new ArrayList<>();
            MowerState mowerState1 = new MowerState(new Point(1, 2), Direction.NORTH);
            // GAGAGAGAA
            List<Action> actions1 = Arrays.asList(ROTATE_COUNTERCLOCKWISE, MOVE_FORWARD, ROTATE_COUNTERCLOCKWISE,
                    MOVE_FORWARD, ROTATE_COUNTERCLOCKWISE, MOVE_FORWARD, ROTATE_COUNTERCLOCKWISE, MOVE_FORWARD,
                    MOVE_FORWARD);
            mowerInstructionsSpecs.add(new MowerInstructionsSpec(mowerState1, actions1));
            List<Action> actions2 = Arrays.asList(MOVE_FORWARD, MOVE_FORWARD, ROTATE_CLOCKWISE, MOVE_FORWARD,
                    MOVE_FORWARD, ROTATE_CLOCKWISE, MOVE_FORWARD, ROTATE_CLOCKWISE, ROTATE_CLOCKWISE, MOVE_FORWARD);
            MowerState mowerState2 = new MowerState(new Point(3, 3), Direction.EAST);
            mowerInstructionsSpecs.add(new MowerInstructionsSpec(mowerState2, actions2));
            MowerOperatorSpec expectedOperatorSpec = new MowerOperatorSpec(expectedGrid, mowerInstructionsSpecs);
            assertTrue(expectedOperatorSpec.equals(operatorSpec));
        }
    }

}
