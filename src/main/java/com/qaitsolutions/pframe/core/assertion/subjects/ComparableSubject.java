package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.collect.Range;
import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;

/**
 * Wrapper over {@link com.google.common.truth.ComparableSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public class ComparableSubject<T extends Comparable> extends Subject {

    private final T actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public ComparableSubject(T actual, String message) {
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
    public ComparableSubject(T actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Checks that the subject is in range. Wrapper over
     * {@link com.google.common.truth.ComparableSubject#isIn(Range)}.
     * <p>
     *
     * @param range Value to be verified against.
     */
    public final void isIn(Range<T> range) {
        try {
            Truth.assertThat(actual).isIn(range);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is not in range. Wrapper over
     * {@link com.google.common.truth.ComparableSubject#isNotIn(Range)}.
     * <p>
     *
     * @param range Value to be verified against.
     */
    public final void isNotIn(Range<T> range) {
        try {
            Truth.assertThat(actual).isNotIn(range);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is equivalent to {@code other} according to {@link Comparable#compareTo}.
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isEquivalentAccordingToCompareTo(Comparable)}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void isEquivalentAccordingToCompareTo(T expected) {
        try {
            Truth.assertThat(actual).isEquivalentAccordingToCompareTo(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is greater than {@code other}. Wrapper over
     * {@link com.google.common.truth.ComparableSubject#isGreaterThan(Comparable)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public final void isGreaterThan(T other) {
        try {
            Truth.assertThat(actual).isGreaterThan(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is less than {@code other}. Wrapper over
     * {@link com.google.common.truth.ComparableSubject#isLessThan(Comparable)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public final void isLessThan(T other) {
        try {
            Truth.assertThat(actual).isLessThan(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is less than or equal to {@code other}. Wrapper over
     * {@link com.google.common.truth.ComparableSubject#isAtMost(Comparable)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public final void isAtMost(T other) {
        try {
            Truth.assertThat(actual).isAtMost(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject is less than or equal to {@code other}. Wrapper over
     * {@link com.google.common.truth.ComparableSubject#isAtLeast(Comparable)}.
     * <p>
     *
     * @param other Value to be verified against.
     */
    public final void isAtLeast(T other) {
        try {
            Truth.assertThat(actual).isAtLeast(other);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
