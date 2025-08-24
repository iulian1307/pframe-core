package com.qaitsolutions.pframe.core.logging;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.qaitsolutions.pframe.core.logging.ConsoleLog.AnsiColor.RESET_COLOR;


/**
 * Class prints messages to console using different colors
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
@FunctionalInterface
public interface ConsoleLog {

    ConsoleLog CYAN = message -> System.out.println(AnsiColor.CYAN.getColor() + message + RESET_COLOR.getColor());
    ConsoleLog RED = message -> System.out.println(AnsiColor.RED.getColor() + message + RESET_COLOR.getColor());
    ConsoleLog YELLOW = message -> System.out.println(AnsiColor.YELLOW.getColor() + message + RESET_COLOR.getColor());
    ConsoleLog GREEN = message -> System.out.println(AnsiColor.GREEN.getColor() + message + RESET_COLOR.getColor());
    ConsoleLog MAGENTA = message -> System.out.println(AnsiColor.MAGENTA.getColor() + message + RESET_COLOR.getColor());

    /**
     * Prints to console a specific text in a specific color, after which the color is reset.
     * <p>
     *
     * @param message Text that will be printed.
     */
    void log(String message);

    /**
     * Holds terminal commands that will change the color of the text displayed
     */
    @AllArgsConstructor @Getter
    enum AnsiColor {
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        CYAN("\u001B[36m"),
        YELLOW("\u001B[33m"),
        MAGENTA("\u001B[35m"),
        RESET_COLOR("\u001B[0m");

        private final String color;
    }
}
