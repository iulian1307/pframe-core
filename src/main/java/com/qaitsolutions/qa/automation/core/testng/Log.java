package com.qaitsolutions.qa.automation.core.testng;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qaitsolutions.qa.automation.core.logging.console.ColorEnum;
import com.qaitsolutions.qa.automation.core.logging.console.ConsoleLog;
import com.qaitsolutions.qa.automation.core.logging.file.FileLog;
import lombok.NonNull;

/**
 * Framework central log that incorporates extent logging, console logging, log4j logging
 */
public class Log {

    /**
     * Logging info level messages
     *
     * @param message Message that will be printed in the log
     */
    public static void info(String message) {
        FrameworkListener.getLog().ifPresent(c -> c.info(message));
        ConsoleLog.log(ColorEnum.CYAN, message);
        FileLog.info(message);
    }

    /**
     * Convenience method for logging info level messages
     *
     * @param message Message that will be printed in the log
     * @param args    Arguments referenced by the format specifiers in the format string
     */
    public static void info(String message, Object... args) {
        info(String.format(message, args));
    }

    /**
     * Logging warning messages
     *
     * @param message Message that will be printed in the log
     */
    public static void warn(String message) {
        FrameworkListener.getLog().ifPresent(c -> c.warning(message));
        ConsoleLog.log(ColorEnum.YELLOW, message);
        FileLog.warn(message);
    }

    /**
     * Convenience method for logging warn level messages
     *
     * @param message Message that will be printed in the log
     * @param args    Arguments referenced by the format specifiers in the format string
     */
    public static void warn(String message, Object... args) {
        warn(String.format(message, args));
    }

    /**
     * Logging warning messages with {@link Throwable}
     *
     * @param message Message that will be printed in the log
     * @param e       Exception to be logged if exists
     */
    public static void warn(String message, Throwable e) {
        FrameworkListener.getLog().ifPresent(c -> c.warning(message));
        ConsoleLog.log(ColorEnum.YELLOW, message);
        FileLog.warn(message, e);
    }

    /**
     * Logging fail messages
     *
     * @param message Message that will be printed in the log
     */
    public static void fail(String message) {
        FrameworkListener.getLog().ifPresent(c -> c.fail(message));
        ConsoleLog.log(ColorEnum.RED, message);
        FileLog.error(message);
    }

    /**
     * Convenience method for logging fail level messages
     *
     * @param message Message that will be printed in the log
     * @param args    Arguments referenced by the format specifiers in the format string
     */
    public static void fail(String message, Object... args) {
        fail(String.format(message, args));
    }

    /**
     * Logging fail messages with {@link Throwable}
     *
     * @param message Message that will be printed in the log
     * @param e       Exception to be logged if exists
     */
    public static void fail(String message, Throwable e) {
        String rawException = e.toString();
        String exceptionDescription = rawException.contains("\n")
                ? rawException.replaceAll("\n", " ")
                : rawException;

        String fullMessage = message + " - " + exceptionDescription.replaceAll("\n", " ");

        FrameworkListener.getLog().ifPresent(c -> c.fail(fullMessage));
        ConsoleLog.log(ColorEnum.RED, fullMessage);
        FileLog.error(message, e);
    }

    /**
     * Logging pass messages
     *
     * @param message Message that will be printed in the log
     */
    public static void pass(String message) {
        FrameworkListener.getLog().ifPresent(c -> c.pass(message));
        ConsoleLog.log(ColorEnum.GREEN, message);
        FileLog.info(message);
    }

    /**
     * Convenience method for logging pass level messages
     *
     * @param message Message that will be printed in the log
     * @param args    Arguments referenced by the format specifiers in the format string
     */
    public static void pass(String message, Object... args) {
        pass(String.format(message, args));
    }

    /**
     * Logging skip messages
     *
     * @param message Message that will be printed in the log
     */
    public static void skip(String message) {
        FrameworkListener.getLog().ifPresent(c -> c.skip(message));
        ConsoleLog.log(ColorEnum.YELLOW, message);
        FileLog.warn(message);
    }

    /**
     * Convenience method for logging skip level messages
     *
     * @param message Message that will be printed in the log
     * @param args    Arguments referenced by the format specifiers in the format string
     */
    public static void skip(String message, Object... args) {
        skip(String.format(message, args));
    }

    /**
     * Logging debug messages
     *
     * @param message Message that will be printed in the log
     */
    public static void debug(String message) {
        ConsoleLog.log(ColorEnum.MAGENTA, message);
        FileLog.debug(message);
    }

    /**
     * Convenience method for logging debug level messages
     *
     * @param message Message that will be printed in the log
     * @param args    Arguments referenced by the format specifiers in the format string
     */
    public static void debug(String message, Object... args) {
        debug(String.format(message, args));
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void attachFileToReport(@NonNull final String message, @NonNull final String path) {
        try {
            FrameworkListener.getLog().ifPresent(
                    l -> l.info(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build())
            );
        } catch (Exception e) {
            warn("Failed to attach image to report");
        }
    }
}
