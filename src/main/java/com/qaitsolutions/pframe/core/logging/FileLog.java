package com.qaitsolutions.pframe.core.logging;

import lombok.NonNull;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Wrapper class for log4j logging {@link Logger}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class FileLog {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Logs a message at debug level. Wrapper over {@link Logger#log(Level, String)}.
     * <p>
     *
     * @param message Text that will appear in the log.
     */
    public static void debug(@NonNull final String message) {
        LOGGER.log(Level.DEBUG, message);
    }

    /**
     * Logs a message at info level. Wrapper over {@link Logger#log(Level, String)}.
     * <p>
     *
     * @param message Text that will appear in the log.
     */
    public static void info(@NonNull final String message) {
        LOGGER.log(Level.INFO, message);
    }

    /**
     * Logs a message at warn level. Wrapper over {@link Logger#log(Level, String)}.
     * <p>
     *
     * @param message Text that will appear in the log.
     */
    public static void warn(@NonNull final String message) {
        LOGGER.log(Level.WARN, message);
    }

    /**
     * Logs a message at warn level with full stack trace. Wrapper over {@link Logger#log(Level, String)}.
     * <p>
     *
     * @param message Text that will appear in the log
     * @param cause   {@link Throwable} that will be used to log the stack trace
     */
    public static void warn(@NonNull final String message, @NonNull final Throwable cause) {
        Level level = Level.WARN;

        LOGGER.log(level, message);
        exceptionChainLog(level, cause);
    }

    /**
     * Logs a message at error level. Wrapper over {@link Logger#log(Level, String)}.
     * <p>
     *
     * @param message Text that will appear in the log
     */
    public static void error(@NonNull final String message) {
        LOGGER.log(Level.ERROR, message);
    }

    /**
     * Logs message at Error level with full stack trace. Wrapper over {@link Logger#log(Level, String)}.
     * <p>
     *
     * @param message Text that will appear in the log.
     * @param cause   {@link Throwable} will be used to get the full stack trace and log it.
     */
    public static void error(@NonNull final String message, @NonNull final Throwable cause) {
        var level = Level.ERROR;

        LOGGER.log(level, message);
        exceptionChainLog(level, cause);
    }

    /**
     * Handles detailed information logging for full exception chain.
     * <p>
     *
     * @param level {@link Level} to be logged at.
     * @param e     {@link Throwable} to be parsed and logged.
     */
    private static void exceptionChainLog(@NonNull final Level level, @NonNull Throwable e) {
        Throwable cause;
        var incidentHash = generateDebugLogHash();

        stackLog(level, e, incidentHash);

        while ((cause = e.getCause()) != null && e != cause) {
            e = cause;
            stackLog(level, e, incidentHash);
        }
    }

    /**
     * Method handles detailed information logging exception stack.
     * <p>
     *
     * @param level        {@link Level} to be logged at.
     * @param e            {@link Throwable} to be parsed and logged.
     * @param incidentHash Hash that will be used to keep track of the stack trace.
     */
    private static void stackLog(
            @NonNull final Level level,
            @NonNull final Throwable e,
            @NonNull final String incidentHash
    ) {
        var message = "[caused_by] " + "[" + e.getClass().getSimpleName() + "] " + e.getMessage();
        LOGGER.log(level, message);

        var stack = e.getStackTrace();
        Arrays.stream(stack).forEach(t -> debug(incidentHash + "[stacktrace] " + t));
    }

    /**
     * Generates a random hash that will be used to keep track of a stack trace.
     * <p>
     *
     * @return Random generated hash as {@link String}.
     */
    private static String generateDebugLogHash() {
        return "[#" + DigestUtils.sha256Hex(Long.toString(System.currentTimeMillis())).substring(0, 7) + "]";
    }
}
