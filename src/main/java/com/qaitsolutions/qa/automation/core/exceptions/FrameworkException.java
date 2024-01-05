package com.qaitsolutions.qa.automation.core.exceptions;

/**
 * Class is custom exception for framework related exceptions
 */
public class FrameworkException extends RuntimeException {

    public FrameworkException(String message, Throwable e) {
        super(message, e);
    }

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(Throwable e) {
        super(e);
    }

    public FrameworkException() {
        super();
    }
}
