package com.qaitsolutions.qa.automation.core.logging.file;

import lombok.NonNull;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Log4j - accessibility entity
 */
public class FileLog {

    private static final Logger FILE_LOG = LogManager.getLogger();

    /**
     * @param message text that will be logged.
     */
    public static void debug(@NonNull final String message) {
        FILE_LOG.log(Level.DEBUG, message);
    }

    /**
     * @param message text that will be logged.
     */
    public static void info(@NonNull final String message) {
        FILE_LOG.log(Level.INFO, message);
    }

    /**
     * @param message text that will be logged.
     */
    public static void warn(@NonNull final String message) {
        FILE_LOG.log(Level.WARN, message);
    }

    /**
     * @param message text that will be logged.
     * @param e       {@link Throwable} that will be used to log the stack trace
     */
    public static void warn(@NonNull final String message, @NonNull final Throwable e) {
        Level level = Level.WARN;

        FILE_LOG.log(level, message);
        exceptionChainLog(level, e);
    }

    /**
     * @param message text that will be logged.
     */
    public static void error(@NonNull final String message) {
        FILE_LOG.log(Level.ERROR, message);
    }

    /**
     * Method logs message at {@link Level#ERROR} level with stack trace in file, console and report
     *
     * @param message text that will be logged.
     * @param e       {@link Throwable} that will be used to log the stack trace
     */
    public static void error(@NonNull final String message, @NonNull final Throwable e) {
        var level = Level.ERROR;

        FILE_LOG.log(level, message);
        exceptionChainLog(level, e);
    }

    /**
     * Method handles detailed information logging for full exception chain
     *
     * @param level {@link Level} to be logged at.
     * @param e     {@link Throwable} to be parsed and logged.
     */
    private static void exceptionChainLog(final Level level, final Throwable e) {
        Throwable cause;
        var result = e;
        var incidentHash = generateDebugLogHash();

        stackLog(level, e, incidentHash);

        while ((cause = result.getCause()) != null && result != cause) {
            result = cause;
            stackLog(level, result, incidentHash);
        }
    }

    /**
     * Method handles detailed information logging exception stack
     *
     * @param level        {@link Level} to be logged at.
     * @param e            {@link Throwable} to be parsed and logged.
     * @param incidentHash hash that will be used to keep track of the stack trace
     */
    private static void stackLog(final Level level, final Throwable e, @NonNull final String incidentHash) {

        var message = "[caused_by]" + "[" + e.getClass().getSimpleName() + "] " + e.getMessage();
        FILE_LOG.log(level, message);

        var stack = e.getStackTrace();
        Arrays.stream(stack).forEach(t -> debug(incidentHash + "[stacktrace] " + t));
    }

    /**
     * Generates a random hash that will be used to keep track of a stack trace
     *
     * @return random generated hash as {@link String}
     */
    private static String generateDebugLogHash() {
        return "[#" + DigestUtils.sha256Hex(Long.toString(System.currentTimeMillis())).substring(0, 7) + "]";
    }
}
