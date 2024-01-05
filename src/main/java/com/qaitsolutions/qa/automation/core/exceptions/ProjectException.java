package com.qaitsolutions.qa.automation.core.exceptions;

public class ProjectException extends FrameworkException {

    public ProjectException(String message, Throwable e) {
        super(message, e);
    }

    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(Throwable e) {
        super(e);
    }
}
