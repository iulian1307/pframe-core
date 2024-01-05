package com.qaitsolutions.qa.automation.core.extent_reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Media;
import lombok.NonNull;

public class ExtentLogger {
    private ExtentTest log;

    public ExtentLogger setLog(@NonNull final ExtentTest logger) {
        log = logger;
        return this;
    }

    /**
     * Method logs message as info section
     */
    public void info(@NonNull final String message) {
        log.info(message);
    }

    /**
     * Method logs message as info section with screenshot
     */
    public void info(@NonNull final String message, @NonNull final Media media) {
        log.info(message, media);
    }

    /**
     * Method logs in report as warning section
     */
    public void warning(@NonNull final String message) {
        log.warning(message);
    }

    /**
     * Method logs in report as failed section
     */
    public void fail(@NonNull final String message) {
        log.fail(message);
    }

    /**
     * Method logs in report as passed section
     */
    public void pass(@NonNull final String message) {
        log.pass(message);
    }

    /**
     * Method logs in report as passed section
     */
    public void skip(@NonNull final String message) {
        log.skip(message);
    }
}
