package org.dbaron.mower.parser;

import com.google.common.collect.ImmutableSet;
import org.dbaron.mower.model.Field;
import org.dbaron.mower.model.Orientation;
import org.dbaron.mower.model.Point;
import org.dbaron.mower.model.Position;
import org.dbaron.mower.model.reference.CardinalOrientation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;

public class BasicConfigurationParserTest {

    private static final ImmutableSet<String> ALLOWED_ORIENTATIONS = ImmutableSet.of("N", "S", "W", "E");
    private static final ImmutableSet<String> ALLOWED_MOVES = ImmutableSet.of("G", "D", "A");

    private static final String DEFAULT_FIELD_DEFINITION = "5 5";
    private static final Position DEFAULT_LOWER_LEFT_HAND_CORNER = new Position(0, 0);
    private static final Position DEFAULT_UPPER_RIGHT_HAND_CORNER = new Position(5, 5);
    private static final Field DEFAULT_FIELD =
            new Field(DEFAULT_LOWER_LEFT_HAND_CORNER, DEFAULT_UPPER_RIGHT_HAND_CORNER);

    private static final String DEFAULT_POINT_DEFINITION = "10 42 W";
    private static final Position POSITION_10_42 = new Position(10, 42);
    private static final Orientation ORIENTATION_W = new Orientation(CardinalOrientation.W.getCode());
    private static final Point POINT_10_42_W = new Point(POSITION_10_42, ORIENTATION_W);

    private final BasicConfigurationParser basicConfigurationParser =
            new BasicConfigurationParser(ALLOWED_ORIENTATIONS, ALLOWED_MOVES);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testParseConfigurationFromList() {

        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Method should be implemented in subclass");

        File file = new File("");
        basicConfigurationParser.parseConfiguration(file);
    }

    @Test
    public void testValidateFieldThrowsIllegalArgumentExceptionForNonNumericValues() {

        List<List <String>> elements = new LinkedList<>();
        elements.add(Arrays.asList("1", "A"));
        elements.add(Arrays.asList("B", "1"));
        elements.add(Arrays.asList("C", "D"));

        for (List<String> element : elements) {
            try {
                basicConfigurationParser.validateField(element);
                fail();
            } catch (IllegalArgumentException iae) {
                // DO NOTHING
            }
        }
    }

    @Test
    public void testValidateFieldThrowsIllegalArgumentExceptionWhenFieldHasLessThanTwoElement() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Wrong number of elements in field definition");

        List<String> fieldElements = Arrays.asList("5");
        basicConfigurationParser.validateField(fieldElements);
    }

    @Test
    public void testValidateFieldThrowsIllegalArgumentExceptionWhenFieldHasMoreThanTwoElements() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Wrong number of elements in field definition");

        List<String> fieldElements = Arrays.asList("5", "5", "5");
        basicConfigurationParser.validateField(fieldElements);
    }

    @Test
    public void testValidateField() {

        List<String> fieldElements = Arrays.asList("5", "5");
        basicConfigurationParser.validateField(fieldElements);
    }

    @Test
    public void testValidatePointThrowsIllegalArgumentExceptionWhenPointHasLessThanThreeElements() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Wrong number of elements in point definition");

        List<String> pointElements = Arrays.asList("1", "2");
        basicConfigurationParser.validatePoint(pointElements);
    }

    @Test
    public void testValidatePointThrowsIllegalArgumentExceptionWhenPointHasMoreThanThreeElements() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Wrong number of elements in point definition");

        List<String> pointElements = Arrays.asList("1", "2", "N", "N");
        basicConfigurationParser.validatePoint(pointElements);
    }

    @Test
    public void testValidatePoint() {

        List<String> pointElements = Arrays.asList("1", "2", "N");
        basicConfigurationParser.validatePoint(pointElements);
    }

    @Test
    public void testValidateMovesThrowsIllegalArgumentExceptionForUnknownMoves() throws Exception {

        List<String> moveElements = Arrays.asList(
                "A", "D", "G",
                "a",
                "A", "A", "D", "D", "G", "G",
                "a", "d",
                "A", "A", "A", "D", "D", "D", "G", "G", "G",
                "a", "d", "g");
        try {
            basicConfigurationParser.validateMoves(moveElements);
            fail();
        } catch (IllegalArgumentException iae) {
            //DO NOTHING
        }
    }

    @Test
    public void testValidateMoves() {

        List<List <String>> moveSequences = new LinkedList<>();

        for (String code1 : ALLOWED_MOVES.asList()) {

            moveSequences.add(Arrays.asList(code1));
            for (String code2 : ALLOWED_MOVES.asList()) {

                moveSequences.add(Arrays.asList(code1, code2));
                for (String code3 : ALLOWED_MOVES.asList()) {

                    moveSequences.add(Arrays.asList(code1, code2, code3));
                }
            }
        }

        for (List<String> moveSequence : moveSequences) {
            basicConfigurationParser.validateMoves(moveSequence);
        }
    }

    @Test
    public void testBuildFieldThrowsIllegalArgumentExceptionForNonNumericValues() {

        Field field = basicConfigurationParser.buildField(DEFAULT_FIELD_DEFINITION);

        assertThat(field, is(notNullValue()));
        assertThat(field.getLowerLeftHandCorner(), is(DEFAULT_LOWER_LEFT_HAND_CORNER));
        assertThat(field.getUpperRightHandCorner(), is(DEFAULT_UPPER_RIGHT_HAND_CORNER));
    }

    @Test
    public void testBuildField() {

        Field field = basicConfigurationParser.buildField(DEFAULT_FIELD_DEFINITION);

        assertThat(field, is(notNullValue()));
        assertThat(field.getLowerLeftHandCorner(), is(DEFAULT_LOWER_LEFT_HAND_CORNER));
        assertThat(field.getUpperRightHandCorner(), is(DEFAULT_UPPER_RIGHT_HAND_CORNER));
    }

    @Test
    public void testBuildPoint() {

        Point point = basicConfigurationParser.buildPoint(DEFAULT_POINT_DEFINITION);

        assertThat(point, is(notNullValue()));

        assertThat(point.getPosition(), is(notNullValue()));
        assertThat(point.getPosition(), is(POINT_10_42_W.getPosition()));

        assertThat(point.getOrientation(), is(notNullValue()));
        assertThat(point.getOrientation(), is(POINT_10_42_W.getOrientation()));
    }
}