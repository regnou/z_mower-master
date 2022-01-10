package fr.xebia.mower.operator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.xebia.mower.controller.MowerController;
import fr.xebia.mower.core.Grid;
import fr.xebia.mower.core.MowerState;

public class MowerOperator {

    private MowerOperatorSpec operatorSpec;

    public MowerOperator(MowerOperatorSpec operatorSpec) {
        this.operatorSpec = operatorSpec;
    }

    private MowerState run(Grid grid, MowerInstructionsSpec spec) {
        MowerController controller = new MowerController(grid, spec.getInitialState());
        controller.performActions(spec.getActions());
        return controller.getCurrentMowerState();
    }

    public Collection<MowerState> run() {
        List<MowerState> states = new ArrayList<>();
        Grid grid = operatorSpec.getGrid();
        for (MowerInstructionsSpec instructionsSpec : operatorSpec.getMowerInstructionsSpecs()) {
            MowerState state = run(grid, instructionsSpec);
            states.add(state);
        }
        return states;
    }

}
