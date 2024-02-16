package com.qaitsolutions.pframe.core.logging;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qaitsolutions.pframe.core.testng.PFrameListener;
import lombok.NonNull;

/**
 * Framework central log that incorporates extent logging, console logging, log4j logging.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class Log {

    /**
     * Logs info level messages. Info level will be sent to:
     * <ul>
     *   <li> FILE
     *   <li> CONSOLE
     *   <li> REPORT
     * </ul>
     *
     * @param message Message that will be printed in the log.
     * @since 1.0
     */
    public static void info(@NonNull final String message) {
        PFrameListener.getLog().ifPresent(c -> c.info(message));
        ConsoleLog.CYAN.log(message);
        FileLog.info(message);
    }

    /**
     * Convenience method for {@link #info(String)} with added {@link String#format(String, Object...)}
     * functionality.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param args    Arguments referenced by the format specifiers in the format string.
     * @since 1.0
     */
    public static void info(@NonNull final String message, final Object... args) {
        info(String.format(message, args));
    }

    /**
     * Logs warning level messages. Warning level will be sent to:
     * <ul>
     *   <li> FILE
     *   <li> CONSOLE
     *   <li> REPORT
     * </ul>
     *
     * @param message Message that will be printed in the log.
     * @since 1.0
     */
    public static void warn(@NonNull final String message) {
        PFrameListener.getLog().ifPresent(c -> c.warning(message));
        ConsoleLog.YELLOW.log(message);

        FileLog.warn(message);
    }

    /**
     * Convenience method for {@link #warn(String)} with added {@link String#format(String, Object...)}
     * functionality.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param args    Arguments referenced by the format specifiers in the format string.
     * @since 1.0
     */
    public static void warn(@NonNull final String message, final Object... args) {
        warn(String.format(message, args));
    }

    /**
     * Logs warning level messages. Same functionality as {@link #warn(String)}, but with the throwable full
     * stacktrace being logged in the log file.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param e       Exception to be logged in log file.
     * @since 1.0
     */
    public static void warn(@NonNull final String message, @NonNull final Throwable e) {
        PFrameListener.getLog().ifPresent(c -> c.warning(message));
        ConsoleLog.YELLOW.log(message);
        FileLog.warn(message, e);
    }

    /**
     * Logs fail level messages. Fail level will be sent to:
     * <ul>
     *   <li> FILE
     *   <li> CONSOLE
     *   <li> REPORT
     * </ul>
     * <p>
     * In the file log the log level is error.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @since 1.0
     */
    public static void fail(@NonNull final String message) {
        PFrameListener.getLog().ifPresent(c -> c.fail(message));
        ConsoleLog.RED.log(message);
        FileLog.error(message);
    }

    /**
     * Convenience method for {@link #fail(String)} with added {@link String#format(String, Object...)}
     * functionality.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param args    Arguments referenced by the format specifiers in the format string.
     * @since 1.0
     */
    public static void fail(@NonNull final String message, final Object... args) {
        fail(String.format(message, args));
    }

    /**
     * Logs fail level messages. Same functionality as {@link #fail(String)}, but with the throwable full
     * stacktrace being logged in the log file.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param e       Exception to be logged in log file.
     * @since 1.0
     */
    public static void fail(@NonNull final String message, final Throwable e) {
        var rawException = e.toString();
        var exceptionDescription = rawException.contains("\n")
                ? rawException.replaceAll("\n", " ")
                : rawException;

        var fullMessage = message + " - " + exceptionDescription.replaceAll("\n", " ");

        PFrameListener.getLog().ifPresent(c -> c.fail(fullMessage));
        ConsoleLog.RED.log(message);
        FileLog.error(message, e);
    }

    /**
     * Logs pass level messages. Pass level will be sent to:
     * <ul>
     *   <li> FILE
     *   <li> CONSOLE
     *   <li> REPORT
     * </ul>
     * <p>
     * In the file log the log level is info.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @since 1.0
     */
    public static void pass(@NonNull final String message) {
        PFrameListener.getLog().ifPresent(c -> c.pass(message));
        ConsoleLog.GREEN.log(message);
        FileLog.info(message);
    }

    /**
     * Convenience method for {@link #pass(String)} with added {@link String#format(String, Object...)}
     * functionality.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param args    Arguments referenced by the format specifiers in the format string.
     * @since 1.0
     */
    public static void pass(@NonNull final String message, final Object... args) {
        pass(String.format(message, args));
    }

    /**
     * Logs skip level messages. Skip level will be sent to:
     * <ul>
     *   <li> FILE
     *   <li> CONSOLE
     *   <li> REPORT
     * </ul>
     *
     * <p>
     * In the file log the log level is warn.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @since 1.0
     */
    public static void skip(@NonNull final String message) {
        PFrameListener.getLog().ifPresent(c -> c.skip(message));
        ConsoleLog.YELLOW.log(message);
        FileLog.warn(message);
    }

    /**
     * Convenience method for {@link #skip(String)} with added {@link String#format(String, Object...)}
     * functionality.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param args    Arguments referenced by the format specifiers in the format string.
     * @since 1.0
     */
    public static void skip(@NonNull final String message, Object... args) {
        skip(String.format(message, args));
    }

    /**
     * Logs debug level messages. Debug level will be sent to:
     * <ul>
     *   <li> FILE
     *   <li> CONSOLE
     * </ul>
     *
     * @param message Message that will be printed in the log.
     * @since 1.0
     */
    public static void debug(@NonNull final String message) {
        ConsoleLog.MAGENTA.log(message);
        FileLog.debug(message);
    }

    /**
     * Convenience method for {@link #debug(String)} with added {@link String#format(String, Object...)}
     * functionality.
     * <p>
     *
     * @param message Message that will be printed in the log.
     * @param args    Arguments referenced by the format specifiers in the format string.
     * @since 1.0
     */
    public static void debug(@NonNull final String message, final Object... args) {
        debug(String.format(message, args));
    }

    /**
     * Logs info level messages with a screenshot attached to the report. This will long in:
     * <ul>
     *  <li> REPORT
     * </ul>
     *
     * @param message Message that will be printed in the report.
     * @param path    Path and filename of the screenshot (e.g. target/report/screenshots/scr.jpg).
     * @since 1.0
     */
    public static void infoWithScreenshotByPath(@NonNull final String message, @NonNull final String path) {
        PFrameListener.getLog()
                .ifPresent(l -> l.info(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build()));
    }

    /**
     * Logs info level messages with a screenshot attached by base64 string. This will long in:
     * <ul>
     *  <li> REPORT
     * </ul>
     *
     * @param message Message that will be printed in the report.
     * @param base64  {@link String} image in base64 encoding.
     * @since 1.0
     */
    public static void infoWithScreenshotByBase64String(@NonNull final String message, @NonNull final String base64) {
        PFrameListener.getLog()
                .ifPresent(l -> l.info(message, MediaEntityBuilder
                        .createScreenCaptureFromBase64String(base64)
                        .build())
                );
    }

    /**
     * Logs info level messages with a json codeblock. This will long in:
     * <ul>
     *   <li> REPORT
     * </ul>
     *
     * @param json Json to be printed in the report.
     * @since 1.0
     */
    public static void infoWithJson(@NonNull final String json) {
        PFrameListener.getLog()
                .ifPresent(l -> l.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON)));
    }

    /**
     * Logs info level messages with a xml codeblock. This will long in:
     * <ul>
     *   <li> REPORT
     * </ul>
     *
     * @param xml XML to be printed in the report.
     */
    public static void infoWithXml(@NonNull final String xml) {
        PFrameListener.getLog()
                .ifPresent(l -> l.info(MarkupHelper.createCodeBlock(xml, CodeLanguage.XML)));
    }
}
