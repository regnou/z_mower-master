package fr.xebia.mower.operator;

import java.util.Collection;

import fr.xebia.mower.controller.Action;
import fr.xebia.mower.core.MowerState;

public class MowerInstructionsSpec {

    private final MowerState initialState;
    private final Collection<Action> actions;

    public MowerInstructionsSpec(MowerState initialState, Collection<Action> actions) {
        this.initialState = initialState;
        this.actions = actions;
    }

    public MowerState getInitialState() {
        return initialState;
    }

    public Collection<Action> getActions() {
        return actions;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof MowerInstructionsSpec)) {
            return false;
        }
        MowerInstructionsSpec instructionsSpec = (MowerInstructionsSpec) other;
        return initialState.equals(instructionsSpec.initialState) && actions.equals(instructionsSpec.actions);
    }

}
