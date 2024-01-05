package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Wrapper over {@link com.google.common.truth.DoubleSubject}
 */
public class DoubleSubject extends ComparableSubject<Double> {

    private final Double actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public DoubleSubject(Double actual, String message) {
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
    public DoubleSubject(Double actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    @Override
    public final void isEqualTo(@Nullable Object other) {
        try {
            super.isEqualTo(other);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    @Override
    public final void isNotEqualTo(@Nullable Object other) {
        try {
            super.isNotEqualTo(other);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isZero()}
     */
    public final void isZero() {
        try {
            Truth.assertThat(actual).isZero();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isNonZero()}
     */
    public final void isNonZero() {
        try {
            Truth.assertThat(actual).isNonZero();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isPositiveInfinity()}
     */
    public final void isPositiveInfinity() {
        try {
            Truth.assertThat(actual).isPositiveInfinity();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isNegativeInfinity()}
     */
    public final void isNegativeInfinity() {
        try {
            Truth.assertThat(actual).isNegativeInfinity();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isNaN()}
     */
    public final void isNaN() {
        try {
            Truth.assertThat(actual).isNaN();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isFinite()}
     */
    public final void isFinite() {
        try {
            Truth.assertThat(actual).isFinite();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isNotNaN()}
     */
    public final void isNotNaN() {
        try {
            Truth.assertThat(actual).isNotNaN();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isGreaterThan(int)}
     */
    public final void isGreaterThan(int other) {
        try {
            Truth.assertThat(actual).isGreaterThan(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isLessThan(int)}
     */
    public final void isLessThan(int other) {
        try {
            Truth.assertThat(actual).isLessThan(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isAtMost(int)}
     */
    public final void isAtMost(int other) {
        try {
            Truth.assertThat(actual).isAtMost(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.DoubleSubject#isAtLeast(int)}
     */
    public final void isAtLeast(int other) {
        try {
            Truth.assertThat(actual).isAtLeast(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
