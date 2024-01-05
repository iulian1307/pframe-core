package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.collect.Range;
import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;

/**
 * Wrapper over {@link com.google.common.truth.ComparableSubject}
 */
@SuppressWarnings("rawtypes")
public class ComparableSubject<T extends Comparable> extends Subject {

    private final T actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public ComparableSubject(T actual, String message) {
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
    public ComparableSubject(T actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isIn(Range)}
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
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isNotIn(Range)}
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
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isEquivalentAccordingToCompareTo(Comparable)}
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
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isGreaterThan(Comparable)}
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
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isLessThan(Comparable)}
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
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isAtMost(Comparable)}
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
     * Wrapper over {@link com.google.common.truth.ComparableSubject#isAtLeast(Comparable)}
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
