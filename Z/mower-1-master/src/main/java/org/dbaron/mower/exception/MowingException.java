package org.dbaron.mower.exception;

/**
 * Created by dbaron on 28/01/15.
 */
public class MowingException extends RuntimeException {

    /**
     * Constructs a <code>MowingException</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public MowingException(String s) {
        super(s);
    }
}