package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;

/**
 * Wrapper over {@link com.google.common.truth.BooleanSubject}
 */
public class BooleanSubject extends Subject {

    private final Boolean actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public BooleanSubject(Boolean actual, String message) {
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
    public BooleanSubject(Boolean actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Wrapper over {@link com.google.common.truth.BooleanSubject#isTrue()}
     */
    public void isTrue() {
        try {
            Truth.assertThat(actual).isTrue();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.BooleanSubject#isFalse()}
     */
    public void isFalse() {
        try {
            Truth.assertThat(actual).isFalse();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
