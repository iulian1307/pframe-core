package com.qaitsolutions.qa.automation.core.logging.console;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Used for console logging purposes, in order to log in different colors.
 */
@AllArgsConstructor @Getter
public enum ColorEnum {

    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    CYAN("\u001B[36m"),
    YELLOW("\u001B[33m"),
    MAGENTA("\u001B[35m");

    private final String color;
}

