package fr.xebia.mower.operator;

import java.awt.Point;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import fr.xebia.mower.controller.Action;
import fr.xebia.mower.core.Direction;
import fr.xebia.mower.core.Grid;
import fr.xebia.mower.core.MowerState;

public class MowerOperatorSpecSerializer {

    private ActionLabelTranslator actionLabelTranslator;

    public MowerOperatorSpecSerializer(ActionLabelTranslator actionLabelTranslator) {
        this.actionLabelTranslator = actionLabelTranslator;
    }

    private Grid extractGrid(Scanner scanner) {
        int width = -1;
        int height = -1;
        if (scanner.hasNextInt()) {
            width = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            height = scanner.nextInt();
        }
        boolean isInvalid = width == -1 || height == -1;
        if (isInvalid) {
            throw new IllegalArgumentException("Invalid file format");
        }
        return new Grid(width, height);
    }

    public MowerState extractMowerState(Scanner scanner) {
        int x = -1;
        int y = -1;
        Direction direction = null;
        if (scanner.hasNextInt()) {
            x = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            y = scanner.nextInt();
        }
        if (scanner.hasNext()) {
            String dir = scanner.next();
            direction = Direction.fromChar(dir.charAt(0));

        }
        boolean isInvalid = x == -1 || y == -1 || direction == null;
        if (isInvalid) {
            throw new IllegalArgumentException("Invalid file format");
        }
        Point position = new Point(x, y);
        return new MowerState(position, direction);
    }

    private Collection<Action> extractActions(Scanner scanner) {
        Collection<Action> actions = new ArrayList<>();
        String line = null;
        if (scanner.hasNext()) {
            line = scanner.next();
            for (char ch : line.toCharArray()) {
                Action action = actionLabelTranslator.getAction(ch + "");
                if (action == null) {
                    throw new IllegalArgumentException("Invalid action lable found:" + ch);
                }
                actions.add(action);
            }
        }

        return actions;
    }

    private MowerInstructionsSpec extractMowerInstructionsSpec(Scanner scanner) {
        MowerState mowerState = extractMowerState(scanner);
        Collection<Action> actions = extractActions(scanner);
        return new MowerInstructionsSpec(mowerState, actions);
    }

    public MowerOperatorSpec deSerialize(InputStream in) {
        Scanner scanner = new Scanner(in);
        Grid grid = extractGrid(scanner);
        Collection<MowerInstructionsSpec> mowerInstructionsSpecs = new ArrayList<>();
        while (scanner.hasNext()) {
            mowerInstructionsSpecs.add(extractMowerInstructionsSpec(scanner));
        }
        return new MowerOperatorSpec(grid, mowerInstructionsSpecs);
    }

}
