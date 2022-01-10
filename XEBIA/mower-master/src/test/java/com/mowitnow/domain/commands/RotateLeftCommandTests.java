package com.mowitnow.domain.commands;

import com.mowitnow.domain.mower.LawnMower;
import com.mowitnow.domain.mower.Mower;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

/**
 * {@link com.mowitnow.domain.commands.RotateLeftCommand} unit testing.
 */
@Test
public class RotateLeftCommandTests {

    public void Given_RotateLeftCommand_When_Execute_Then_VerifyThatMowerRotatedLeft() {
        Mower lawnMower = mock(LawnMower.class);
        RotateLeftCommand rotateLeftCommand = new RotateLeftCommand(lawnMower);

        rotateLeftCommand.execute();

        Mockito.verify(lawnMower).rotateLeft();
    }
}
