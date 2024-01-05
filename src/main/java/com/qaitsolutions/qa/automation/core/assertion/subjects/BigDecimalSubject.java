package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.math.BigDecimal;

/**
 * Wrapper over {@link com.google.common.truth.BigDecimalSubject}
 */
public class BigDecimalSubject extends ComparableSubject<BigDecimal> {

    private final BigDecimal actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public BigDecimalSubject(BigDecimal actual, String message) {
        super(actual, message);
        this.actual = actual;
    }

    /**
     * Constructor for soft assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     * @param tracker Entity which allows keeping track of existing errors
     */
    public BigDecimalSubject(BigDecimal actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Wrapper over {@link com.google.common.truth.BigDecimalSubject#isEqualToIgnoringScale(BigDecimal)}
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
     * Wrapper over {@link com.google.common.truth.BigDecimalSubject#isEqualToIgnoringScale(String)}
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
     * Wrapper over {@link com.google.common.truth.BigDecimalSubject#isEqualToIgnoringScale(long)} )}
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
