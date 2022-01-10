package com.mowitnow.domain.commands;

import com.mowitnow.domain.mower.LawnMower;
import com.mowitnow.domain.mower.Mower;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

/**
 * {@link com.mowitnow.domain.commands.RotateRightCommand} unit testing.
 */
@Test
public class RotateRightCommandTests {

    public void Given_RotateRightCommand_When_Execute_Then_VerifyThatMowerRotatedRight() {
        Mower lawnMower = mock(LawnMower.class);
        RotateRightCommand rotateRightCommand = new RotateRightCommand(lawnMower);

        rotateRightCommand.execute();

        Mockito.verify(lawnMower).rotateRight();
    }
}
