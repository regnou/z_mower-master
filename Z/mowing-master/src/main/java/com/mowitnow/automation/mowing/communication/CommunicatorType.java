package com.mowitnow.automation.mowing.communication;

public enum CommunicatorType {

    CONSOLE;

    public static CommunicatorType fromInput(String input) {
        CommunicatorType communicatorType = CommunicatorType.CONSOLE;
        for(CommunicatorType type : values()) {
            if(type.toString().equalsIgnoreCase(input)) {
                communicatorType = type;
            }
        }
        return communicatorType;
    }

}
