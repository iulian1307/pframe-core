package com.qaitsolutions.pframe.core.extent_reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Media;
import lombok.NonNull;
import lombok.Setter;

/**
 * Wrapper class over {@link ExtentTest}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
@Setter
public final class ExtentLogger {

    private ExtentTest log;

    /**
     * Logs message as info section. Wrapper over {@link ExtentTest#info(String)}. Wrapper over
     * {@link ExtentTest#info(String)}.
     * <p>
     *
     * @param message Text to be added to report.
     */
    public void info(@NonNull final String message) {
        log.info(message);
    }

    /**
     * Logs message as info section with screenshot. Wrapper over {@link ExtentTest#info(String, Media)}.
     * <p>
     *
     * @param message Text to be added to report.
     * @param media   {@link Media} to be added to report.
     */
    public void info(@NonNull final String message, @NonNull final Media media) {
        log.info(message, media);
    }

    /**
     * Method logs message as info section with markup (codeblocks, labels, lists etc). Wrapper over
     * {@link ExtentTest#info(Markup)}.
     * <p>
     *
     * @param markup {@link Markup} to be added to report.
     */
    public void info(@NonNull final Markup markup) {
        log.info(markup);
    }

    /**
     * Logs in report as warning section. Wrapper over {@link ExtentTest#warning(String)}.
     * <p>
     *
     * @param message Text to be added to report.
     */
    public void warning(@NonNull final String message) {
        log.warning(message);
    }

    /**
     * Logs in report as failed section. Wrapper over {@link ExtentTest#fail(String)}.
     * <p>
     *
     * @param message Text to be added to report.
     */
    public void fail(@NonNull final String message) {
        log.fail(message);
    }

    /**
     * Logs in report as passed section. Wrapper over {@link ExtentTest#pass(String)}.
     * <p>
     *
     * @param message Text to be added to report.
     */
    public void pass(@NonNull final String message) {
        log.pass(message);
    }

    /**
     * Logs in report as passed section. Wrapper over {@link ExtentTest#skip(String)}.
     * <p>
     *
     * @param message Text to be added to report.
     */
    public void skip(@NonNull final String message) {
        log.skip(message);
    }
}
