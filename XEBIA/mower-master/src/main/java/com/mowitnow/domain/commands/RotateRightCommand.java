package com.mowitnow.domain.commands;

import com.mowitnow.domain.mower.Mower;

/**
 * {@link com.mowitnow.domain.commands.Command} for rotating the mower (i.e receiver object) 90 degrees to the right.
 */
public class RotateRightCommand implements Command {

    private final Mower mower;

    public RotateRightCommand(Mower mower) {
        this.mower = mower;
    }

    @Override
    public void execute() {
        mower.rotateRight();
    }
}
