package com.qaitsolutions.pframe.core.assertion;

import com.google.common.truth.StandardSubjectBuilder;
import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.subjects.*;
import com.qaitsolutions.pframe.core.logging.Log;

import java.math.BigDecimal;
import java.util.Map;

/**
 * SoftAssertion implementation over {@link com.google.common.truth.Truth}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class SoftAssertions {

    private final ErrorTracker tracker = new ErrorTracker();
    private String message;

    /**
     * Fails when previous asserts fail and failures are registered in the tracker. After fail, the tracker
     * is emptied so that it can be used again.
     *
     * @throws AssertionError If any error has been registered to the point of using this method.
     */
    public void assertAll() {
        if (tracker.containsErrors()) {
            var errors = tracker.getErrors();
            errors.forEach(e -> Log.fail(e.getDescription(), e.getException()));

            tracker.clear();
            throw new AssertionError();
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Integer)}.
     * <p>
     *
     * @param actual Current {@link Integer} value to be verified.
     * @return {@link IntegerSubject} with integer specific assertions methods.
     */
    public IntegerSubject assertThat(Integer actual) {
        return new IntegerSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Iterable)}.
     * <p>
     *
     * @param actual Current {@link Iterable} value to be verified.
     * @return {@link IterableSubject} with specific assertions methods.
     */
    public IterableSubject assertThat(Iterable<?> actual) {
        return new IterableSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Boolean)}.
     * <p>
     *
     * @param actual Current {@link Boolean} value to be verified.
     * @return {@link BooleanSubject} with specific assertions methods.
     */
    public BooleanSubject assertThat(Boolean actual) {
        return new BooleanSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Double)}.
     * <p>
     *
     * @param actual Current {@link Double} value to be verified.
     * @return {@link DoubleSubject} with specific assertions methods.
     */
    public DoubleSubject assertThat(Double actual) {
        return new DoubleSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Float)}.
     * <p>
     *
     * @param actual Current {@link Float} value to be verified.
     * @return {@link DoubleSubject} with specific assertions methods.
     */
    public DoubleSubject assertThat(Float actual) {
        return new DoubleSubject(actual.doubleValue(), message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Long)}.
     * <p>
     *
     * @param actual Current {@link Long} value to be verified.
     * @return {@link LongSubject} with specific assertions methods.
     */
    public LongSubject assertThat(Long actual) {
        return new LongSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(String)}.
     * <p>
     *
     * @param actual Current {@link String} value to be verified.
     * @return {@link StringSubject} with specific assertions methods.
     */
    public StringSubject assertThat(String actual) {
        return new StringSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Comparable)}.
     * <p>
     *
     * @param actual Current {@link Comparable} value to be verified.
     * @return {@link ComparableSubject} with specific assertions methods.
     */
    public <T extends Comparable<?>> ComparableSubject<T> assertThat(T actual) {
        return new ComparableSubject<>(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Object)}.
     * <p>
     *
     * @param actual Current {@link Object} value to be verified.
     * @return {@link Subject} with specific assertions methods.
     */
    public Subject assertThat(Object actual) {
        return new Subject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Map)}.
     * <p>
     *
     * @param actual Current {@link Map} value to be verified.
     * @return {@link MapSubject} with specific assertions methods.
     */
    public MapSubject assertThat(Map<?, ?> actual) {
        return new MapSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(BigDecimal)}.
     * <p>
     *
     * @param actual Current {@link BigDecimal} value to be verified.
     * @return {@link BigDecimalSubject} with specific assertions methods.
     */
    public BigDecimalSubject assertThat(BigDecimal actual) {
        return new BigDecimalSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertWithMessage(String)}.
     * <p>
     *
     * @param message Text that will be added to the log/report.
     * @return A self reference..
     */
    public SoftAssertions assertWithMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertWithMessage(String, Object...)}.
     * <p>
     *
     * @param format Text that will be added to the log/report in {@link String#format(String, Object...)}.
     * @param args   Arguments referenced by the format specifiers in the format string.
     * @return A self reference.
     */
    public SoftAssertions assertWithMessage(String format, Object... args) {
        this.message = String.format(format, args);
        return this;
    }

    /**
     * Will add a fail (error) in the error list but will not fail until {@link #assertAll()} method is used.
     * Wrapper over {@link StandardSubjectBuilder#fail()}.
     */
    public void softFail() {
        try {
            Truth.assert_().fail();
        } catch (AssertionError e) {
            tracker.addError(message, e);
        }
    }

    /**
     * Will fail (error) when used. Wrapper over {@link StandardSubjectBuilder#fail()}.
     * <p>
     *
     * @throws AssertionError When method is used it will throw Error.
     */
    public void hardFail() {
        try {
            Truth.assert_().fail();
        } catch (AssertionError e) {
            message = message != null ? message : "";
            Log.fail(message);
            throw new AssertionError(message, e);
        }
    }
}
