package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.math.BigDecimal;

/**
 * Wrapper over {@link com.google.common.truth.BigDecimalSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class BigDecimalSubject extends ComparableSubject<BigDecimal> {

    private final BigDecimal actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public BigDecimalSubject(BigDecimal actual, String message) {
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
    public BigDecimalSubject(BigDecimal actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Fails if the subject's value is not equal to the value of the given BigDecimal.
     * Wrapper over {@link com.google.common.truth.BigDecimalSubject#isEqualToIgnoringScale(BigDecimal)}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void isEqualToIgnoringScale(BigDecimal expected) {
        try {
            Truth.assertThat(actual).isEqualToIgnoringScale(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the subject's value is not equal to the value of the BigDecimal created from the expected string.
     * Wrapper over {@link com.google.common.truth.BigDecimalSubject#isEqualToIgnoringScale(String)}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void isEqualToIgnoringScale(String expected) {
        try {
            Truth.assertThat(actual).isEqualToIgnoringScale(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the subject's value is not equal to the value of the BigDecimal created from the expected long.
     * Wrapper over {@link com.google.common.truth.BigDecimalSubject#isEqualToIgnoringScale(long)} )}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void isEqualToIgnoringScale(long expected) {
        try {
            Truth.assertThat(actual).isEqualToIgnoringScale(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    @Override
    public void isEqualTo(@Nullable Object expected) {
        try {
            super.isEqualTo(expected);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    @Override
    public void isEquivalentAccordingToCompareTo(BigDecimal expected) {
        try {
            Truth.assertThat(actual).isEquivalentAccordingToCompareTo(expected);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
