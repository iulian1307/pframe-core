package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;

/**
 * Wrapper over {@link com.google.common.truth.Subject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public class Subject {

    private final Object actual;
    protected String message;
    protected ErrorTracker tracker;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public Subject(Object actual, String message) {
        this.actual = actual;
        this.message = message;
    }

    /**
     * Constructor for soft assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     * @param tracker Entity which allows keeping track of existing errors.
     */
    public Subject(Object actual, String message, ErrorTracker tracker) {
        this.actual = actual;
        this.message = message;
        this.tracker = tracker;
    }

    /**
     * Fails if the subject is not null. Wrapper over {@link com.google.common.truth.Subject#isNull()}.
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
     * Fails if the subject is null. Wrapper over {@link com.google.common.truth.Subject#isNotNull()}.
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
     * Fails if the subject is not equal to the given object. Wrapper over
     * {@link com.google.common.truth.Subject#isEqualTo(Object)}.
     * <p>
     *
     * @param expected Value to be checked against.
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
     * Fails if the subject is equal to the given object. The meaning of equality is the same as for
     * the {@link #isEqualTo} method. Wrapper over {@link com.google.common.truth.Subject#isNotEqualTo(Object)}.
     * <p>
     *
     * @param unexpected Value to be checked against.
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
     * Fails if the subject is not the same instance as the given object. Wrapper over
     * {@link com.google.common.truth.Subject#isSameInstanceAs(Object)}.
     * <p>
     *
     * @param expected Value to be checked against.
     */
    public void isSameInstanceAs(Object expected) {
        try {
            Truth.assertThat(actual).isSameInstanceAs(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the subject is the same instance as the given object. Wrapper over
     * {@link com.google.common.truth.Subject#isNotSameInstanceAs(Object)}.
     * <p>
     *
     * @param unexpected Value to be checked against.
     */
    public void isNotSameInstanceAs(Object unexpected) {
        try {
            Truth.assertThat(actual).isNotSameInstanceAs(unexpected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the subject is not an instance of the given class. Wrapper over
     * {@link com.google.common.truth.Subject#isInstanceOf(Class)}.
     * <p>
     *
     * @param clazz Value to be checked against.
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
     * Fails if the subject is an instance of the given class. Wrapper over
     * {@link com.google.common.truth.Subject#isNotInstanceOf(Class)}.
     * <p>
     *
     * @param clazz Value to be checked against.
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
     * Fails unless the subject is equal to any element in the given iterable. Wrapper over
     * {@link com.google.common.truth.Subject#isIn(Iterable)}.
     * <p>
     *
     * @param iterable Value to be checked against.
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
     * Fails unless the subject is equal to any of the given elements. Wrapper over
     * {@link com.google.common.truth.Subject#isAnyOf(Object, Object, Object...)}.
     * <p>
     *
     * @param first  Value to be checked against.
     * @param second Value to be checked against.
     * @param rest   Value to be checked against.
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
     * Fails if the subject is equal to any element in the given iterable. Wrapper over
     * {@link com.google.common.truth.Subject#isNotIn(Iterable)}.
     * <p>
     *
     * @param iterable Value to be checked against.
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
     * Fails if the subject is equal to any of the given elements. Wrapper over
     * {@link com.google.common.truth.Subject#isNoneOf(Object, Object, Object...)}.
     * <p>
     *
     * @param first  Value to be checked against.
     * @param second Value to be checked against.
     * @param rest   Value to be checked against.
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
