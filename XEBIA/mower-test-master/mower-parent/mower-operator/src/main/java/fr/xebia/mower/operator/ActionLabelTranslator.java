package fr.xebia.mower.operator;

import java.util.HashMap;
import java.util.Map;

import fr.xebia.mower.controller.Action;

/**
 * Used to translate a label (String) into the appropriate Action
 */
public final class ActionLabelTranslator {

    private static final Map<String, Action> FRENCH_TRANSLATION_MAP = initFrenchTranslationMap();

    public static final ActionLabelTranslator FRENCH_LABEL_TRANSLATOR = new ActionLabelTranslator(
            FRENCH_TRANSLATION_MAP);

    private Map<String, Action> translationMap;

    private ActionLabelTranslator(Map<String, Action> translationMap) {
        this.translationMap = translationMap;
    }

    public Action getAction(String label) {
        Action action = translationMap.get(label);
        if (action == null) {
            throw new IllegalArgumentException(label + " is not a valid label");
        }
        return action;
    }

    private static Map<String, Action> initFrenchTranslationMap() {
        Map<String, Action> translationMap = new HashMap<>();
        translationMap.put("D", Action.ROTATE_CLOCKWISE);
        translationMap.put("G", Action.ROTATE_COUNTERCLOCKWISE);
        translationMap.put("A", Action.MOVE_FORWARD);
        return translationMap;
    }

}
