package com.qaitsolutions.qa.automation.core.exceptions;

/**
 * Class is custom exception for framework related exceptions
 */
public class TestSetupException extends FrameworkException {

    public TestSetupException(String message, Throwable e) {
        super(message, e);
    }

    public TestSetupException(String message) {
        super(message);
    }
}
