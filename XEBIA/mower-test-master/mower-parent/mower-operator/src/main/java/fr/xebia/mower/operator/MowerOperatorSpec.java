package fr.xebia.mower.operator;

import java.util.Collection;

import fr.xebia.mower.core.Grid;;

public class MowerOperatorSpec {

    private final Grid grid;
    private final Collection<MowerInstructionsSpec> mowerInstructionsSpecs;

    public MowerOperatorSpec(Grid grid, Collection<MowerInstructionsSpec> mowerInstructionsSpecs) {
        this.grid = grid;
        this.mowerInstructionsSpecs = mowerInstructionsSpecs;
    }

    public Grid getGrid() {
        return grid;
    }

    public Collection<MowerInstructionsSpec> getMowerInstructionsSpecs() {
        return mowerInstructionsSpecs;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof MowerOperatorSpec)) {
            return false;
        }
        MowerOperatorSpec operatorSpec = (MowerOperatorSpec) other;
        return grid.equals(operatorSpec.grid) && mowerInstructionsSpecs.equals(operatorSpec.mowerInstructionsSpecs);
    }

}
