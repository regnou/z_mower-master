package fr.xebia.operator;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collection;

import fr.xebia.mower.core.MowerState;
import fr.xebia.mower.operator.ActionLabelTranslator;
import fr.xebia.mower.operator.MowerOperator;
import fr.xebia.mower.operator.MowerOperatorSpec;
import fr.xebia.mower.operator.MowerOperatorSpecSerializer;

public class Main {

    private static void printMowerState(MowerState mowerState) {
        Point position = mowerState.getPosition();
        System.out.println(
                (int) position.getX() + " " + (int) position.getY() + " " + mowerState.getDirection().name().charAt(0));
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Path to MowerOperatorSpec file is missing.");
            return;
        }
        String path = args[0];
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("The provided path is not valid");
        }
        try (InputStream in = Files.newInputStream(file.toPath(), StandardOpenOption.READ)) {
            MowerOperatorSpecSerializer operatorSpecSerializer = new MowerOperatorSpecSerializer(
                    ActionLabelTranslator.FRENCH_LABEL_TRANSLATOR);
            MowerOperatorSpec operatorSpec = operatorSpecSerializer.deSerialize(in);
            MowerOperator operator = new MowerOperator(operatorSpec);
            Collection<MowerState> result = operator.run();
            for (MowerState mowerState : result) {
                printMowerState(mowerState);
            }
        } catch (IOException e) {
            System.out.println("An unexpected error has occured:");
            e.printStackTrace();
        }

    }

}
