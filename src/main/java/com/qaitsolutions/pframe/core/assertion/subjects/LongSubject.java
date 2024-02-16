package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;

/**
 * Wrapper over {@link com.google.common.truth.LongSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class LongSubject extends ComparableSubject<Long> {

    private final Long actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public LongSubject(Long actual, String message) {
        super(actual, message);
        this.actual = actual;
    }

    /**
     * Constructor for soft assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     * @param tracker Entity which allows keeping track of existing errors.
     */
    public LongSubject(Long actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Checks that the subject is greater than {@code other}. Wrapper over
     * {@link com.google.common.truth.LongSubject#isGreaterThan(int)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public void isGreaterThan(int other) {
        try {
            Truth.assertThat(actual).isGreaterThan(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is less than {@code other}. Wrapper over
     * {@link com.google.common.truth.LongSubject#isLessThan(int)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public void isLessThan(int other) {
        try {
            Truth.assertThat(actual).isLessThan(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is less than or equal to {@code other}. Wrapper over
     * {@link com.google.common.truth.LongSubject#isAtMost(int)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public void isAtMost(int other) {
        try {
            Truth.assertThat(actual).isAtMost(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is greater than or equal to {@code other}. Wrapper over
     * {@link com.google.common.truth.LongSubject#isAtLeast(int)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public void isAtLeast(int other) {
        try {
            Truth.assertThat(actual).isAtLeast(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
