package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;

/**
 * Wrapper over {@link com.google.common.truth.BooleanSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class BooleanSubject extends Subject {

    private final Boolean actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public BooleanSubject(Boolean actual, String message) {
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
    public BooleanSubject(Boolean actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Fails if the subject is false or null. Wrapper over {@link com.google.common.truth.BooleanSubject#isTrue()}.
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
     * Fails if the subject is true or null. Wrapper over {@link com.google.common.truth.BooleanSubject#isFalse()}.
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
