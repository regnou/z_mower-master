package com.mowitnow.domain.commands;

import com.mowitnow.domain.lawn.DefaultLawnFixtures;
import com.mowitnow.domain.lawn.Lawn;
import com.mowitnow.domain.mower.LawnMower;
import com.mowitnow.domain.mower.LawnMowerFixtures;
import com.mowitnow.domain.mower.Mower;
import com.mowitnow.domain.mower.Orientation;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

/**
 * {@link com.mowitnow.domain.commands.MoveCommand} unit testing.
 */
@Test
public class MoveCommandTests {

    public void Given_MoveCommand_When_Execute_Then_VerifyThatTheMowerMoved() {
        Mower lawnMower = mock(LawnMower.class);
        Lawn lawn = DefaultLawnFixtures.newDefaultLawn();
        MoveCommand moveCommand = new MoveCommand(lawnMower, lawn);

        moveCommand.execute();

        Mockito.verify(lawnMower).move();
    }

    public void Given_MowerAtTopFacingNorthAndMoveCommand_When_Execute_Then_VerifyThatTheMowerStayedAtTheSamePosition() {
        Mower mower = LawnMowerFixtures.newLawnMowerAtGivenPositionFacingGivenOrientation(1, 1, Orientation.NORTH);
        Lawn lawn = DefaultLawnFixtures.newDefaultLawn();
        Command moveCommand = new MoveCommand(mower, lawn);

        moveCommand.execute();

        assertEquals(mower.getX(), 1);
        assertEquals(mower.getY(), 1);
    }
}
