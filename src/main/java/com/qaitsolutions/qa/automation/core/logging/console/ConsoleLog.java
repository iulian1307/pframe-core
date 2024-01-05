package com.qaitsolutions.qa.automation.core.logging.console;

/**
 * ConsoleLog prints messages to console for quick debugging.
 */
public class ConsoleLog {

    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Prints to console a specific text in a specific color, after which the color is reset.
     *
     * @param color   color in which the text will be printed.
     * @param message text that will be printed.
     */
    public static void log(ColorEnum color, String message) {
        System.out.println(color.getColor() + message + ANSI_RESET);
    }
}
