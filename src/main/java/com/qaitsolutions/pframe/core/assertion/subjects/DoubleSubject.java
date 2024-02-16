package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Wrapper over {@link com.google.common.truth.DoubleSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class DoubleSubject extends ComparableSubject<Double> {

    private final Double actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public DoubleSubject(Double actual, String message) {
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
    public DoubleSubject(Double actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    @Override
    public void isEqualTo(@Nullable Object other) {
        try {
            super.isEqualTo(other);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    @Override
    public void isNotEqualTo(@Nullable Object other) {
        try {
            super.isNotEqualTo(other);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Asserts that the subject is zero. Wrapper over {@link com.google.common.truth.DoubleSubject#isZero()}.
     */
    public void isZero() {
        try {
            Truth.assertThat(actual).isZero();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Asserts that the subject is a non-null value other than zero. Wrapper over
     * {@link com.google.common.truth.DoubleSubject#isNonZero()}.
     */
    public void isNonZero() {
        try {
            Truth.assertThat(actual).isNonZero();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Asserts that the subject is {@link Double#POSITIVE_INFINITY}. Wrapper over
     * {@link com.google.common.truth.DoubleSubject#isPositiveInfinity()}.
     */
    public void isPositiveInfinity() {
        try {
            Truth.assertThat(actual).isPositiveInfinity();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Asserts that the subject is {@link Double#NEGATIVE_INFINITY}. Wrapper over
     * {@link com.google.common.truth.DoubleSubject#isNegativeInfinity()}.
     */
    public void isNegativeInfinity() {
        try {
            Truth.assertThat(actual).isNegativeInfinity();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Asserts that the subject is {@link Double#NaN}. Wrapper over
     * {@link com.google.common.truth.DoubleSubject#isNaN()}.
     */
    public void isNaN() {
        try {
            Truth.assertThat(actual).isNaN();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Asserts that the subject is finite. Wrapper over {@link com.google.common.truth.DoubleSubject#isFinite()}.
     */
    public void isFinite() {
        try {
            Truth.assertThat(actual).isFinite();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Asserts that the subject is a non-null value other than {@link Double#NaN}. Wrapper over
     * {@link com.google.common.truth.DoubleSubject#isNotNaN()}.
     */
    public void isNotNaN() {
        try {
            Truth.assertThat(actual).isNotNaN();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is greater than {@code other}. Wrapper over
     * {@link com.google.common.truth.DoubleSubject#isGreaterThan(int)}.
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
     * {@link com.google.common.truth.DoubleSubject#isLessThan(int)}.
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
     * {@link com.google.common.truth.DoubleSubject#isAtMost(int)}.
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
     * {@link com.google.common.truth.DoubleSubject#isAtLeast(int)}.
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
