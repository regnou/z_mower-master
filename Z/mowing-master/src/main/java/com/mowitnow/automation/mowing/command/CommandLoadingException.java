package com.mowitnow.automation.mowing.command;

public class CommandLoadingException extends Exception {

    public CommandLoadingException(String message) {
        super(message);
    }

    public CommandLoadingException(Throwable cause) {
        super(cause);
    }
}
