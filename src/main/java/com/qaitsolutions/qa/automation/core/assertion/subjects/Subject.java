package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;

/**
 * Wrapper over {@link com.google.common.truth.Subject}
 */
public class Subject {

    private final Object actual;
    protected String message;
    protected ErrorTracker tracker;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public Subject(Object actual, String message) {
        this.actual = actual;
        this.message = message;
    }

    /**
     * Constructor for soft assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     * @param tracker Entity which allows keeping track of existing errors
     */
    public Subject(Object actual, String message, ErrorTracker tracker) {
        this.actual = actual;
        this.message = message;
        this.tracker = tracker;
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isNull()}
     */
    public void isNull() {
        try {
            Truth.assertThat(actual).isNull();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isNotNull()}
     */
    public void isNotNull() {
        try {
            Truth.assertThat(actual).isNotNull();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isEqualTo(Object)}
     */
    public void isEqualTo(Object expected) {
        try {
            Truth.assertThat(actual).isEqualTo(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isNotEqualTo(Object)}
     */
    public void isNotEqualTo(Object unexpected) {
        try {
            Truth.assertThat(actual).isNotEqualTo(unexpected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isSameInstanceAs(Object)}
     */
    public final void isSameInstanceAs(Object expected) {
        try {
            Truth.assertThat(actual).isSameInstanceAs(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isNotSameInstanceAs(Object)}
     */
    public final void isNotSameInstanceAs(Object unexpected) {
        try {
            Truth.assertThat(actual).isNotSameInstanceAs(unexpected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isInstanceOf(Class)}
     */
    public void isInstanceOf(Class<?> clazz) {
        try {
            Truth.assertThat(actual).isInstanceOf(clazz);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isNotInstanceOf(Class)}
     */
    public void isNotInstanceOf(Class<?> clazz) {
        try {
            Truth.assertThat(actual).isNotInstanceOf(clazz);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isIn(Iterable)}
     */
    public void isIn(Iterable<?> iterable) {
        try {
            Truth.assertThat(actual).isIn(iterable);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isAnyOf(Object, Object, Object...)}
     */
    public void isAnyOf(Object first, Object second, Object... rest) {
        try {
            Truth.assertThat(actual).isAnyOf(first, second, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isNotIn(Iterable)}
     */
    public void isNotIn(Iterable<?> iterable) {
        try {
            Truth.assertThat(actual).isNotIn(iterable);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Subject#isNoneOf(Object, Object, Object...)}
     */
    public void isNoneOf(Object first, Object second, Object... rest) {
        try {
            Truth.assertThat(actual).isNoneOf(first, second, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
