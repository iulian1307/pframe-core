package com.qaitsolutions.pframe.core.exceptions;

/**
 * Class is custom exception for framework related exceptions.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public class FrameworkException extends RuntimeException {

    /**
     * Constructs a new framework exception with the specified message and cause.
     * <p>
     *
     * @param message Detailed text of exception.
     * @param cause   The cause of the exception.
     */
    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new framework exception with the specified message.
     * <p>
     *
     * @param message Detailed text of exception.
     */
    public FrameworkException(String message) {
        super(message);
    }

    /**
     * Constructs a new framework exception with the specified cause.
     * <p>
     *
     * @param cause The cause of the exception.
     */
    public FrameworkException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new framework exception.
     */
    public FrameworkException() {
        super();
    }
}
