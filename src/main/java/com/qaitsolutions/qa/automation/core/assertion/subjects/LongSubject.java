package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;

/**
 * Wrapper over {@link com.google.common.truth.LongSubject}
 */
public class LongSubject extends ComparableSubject<Long> {

    private final Long actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public LongSubject(Long actual, String message) {
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
    public LongSubject(Long actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Wrapper over {@link com.google.common.truth.LongSubject#isGreaterThan(int)}
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
     * Wrapper over {@link com.google.common.truth.LongSubject#isLessThan(int)}
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
     * Wrapper over {@link com.google.common.truth.LongSubject#isAtMost(int)}
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
     * Wrapper over {@link com.google.common.truth.LongSubject#isAtLeast(int)}
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
