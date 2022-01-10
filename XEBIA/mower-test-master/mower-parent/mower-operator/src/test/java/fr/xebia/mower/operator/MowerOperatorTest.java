package fr.xebia.mower.operator;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;

import fr.xebia.mower.core.MowerState;

public class MowerOperatorTest {
    private static final String TEST1_IN_FILENAME = "serialization1_in.txt";
    private static final String TEST1_OUT_FILENAME = "serialization1_out.txt";

    private Collection<MowerState> getExpectedMowerStates(String filename) throws IOException {
        try (InputStream in = getClass().getResourceAsStream("/" + filename)) {
            Scanner scanner = new Scanner(in);
            Collection<MowerState> mowerStates = new ArrayList<>();
            MowerOperatorSpecSerializer mowerSerializer = new MowerOperatorSpecSerializer(
                    ActionLabelTranslator.FRENCH_LABEL_TRANSLATOR);
            while (scanner.hasNext()) {
                MowerState mowerState = mowerSerializer.extractMowerState(scanner);
                mowerStates.add(mowerState);
            }
            return mowerStates;
        }
    }

    @Test
    public void testOperator1() throws IOException {
        try (InputStream in = getClass().getResourceAsStream("/" + TEST1_IN_FILENAME)) {

            MowerOperatorSpecSerializer serializer = new MowerOperatorSpecSerializer(
                    ActionLabelTranslator.FRENCH_LABEL_TRANSLATOR);
            MowerOperatorSpec operatorSpec = serializer.deSerialize(in);
            MowerOperator mowerOperator = new MowerOperator(operatorSpec);
            Collection<MowerState> mowerStates = mowerOperator.run();
            Collection<MowerState> expectedMowerStates = getExpectedMowerStates(TEST1_OUT_FILENAME);
            assertTrue(expectedMowerStates.equals(mowerStates));

        }
    }

}
