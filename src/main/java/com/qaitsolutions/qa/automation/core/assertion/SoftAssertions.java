package com.qaitsolutions.qa.automation.core.assertion;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.subjects.*;
import com.qaitsolutions.qa.automation.core.testng.Log;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Wrapper over {@link com.google.common.truth.Truth}
 */
public class SoftAssertions {

    private final ErrorTracker tracker = new ErrorTracker();
    private String message;

    /**
     * Fails when previous asserts fail and failures are registered in the tracker. After fail, the tracker
     * is emptied so that it can be used again.
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
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Integer)}
     */
    public IntegerSubject assertThat(Integer actual) {
        return new IntegerSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Iterable)}
     */
    public IterableSubject assertThat(Iterable<?> actual) {
        return new IterableSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Boolean)}
     */
    public BooleanSubject assertThat(Boolean actual) {
        return new BooleanSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Double)}
     */
    public DoubleSubject assertThat(Double actual) {
        return new DoubleSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Float)}
     */
    public DoubleSubject assertThat(Float actual) {
        return new DoubleSubject(actual.doubleValue(), message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Long)}
     */
    public LongSubject assertThat(Long actual) {
        return new LongSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(String)}
     */
    public StringSubject assertThat(String actual) {
        return new StringSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Comparable)}
     */
    public <T extends Comparable<?>> ComparableSubject<T> assertThat(T actual) {
        return new ComparableSubject<>(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Object)}
     */
    public Subject assertThat(Object actual) {
        return new Subject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Map)}
     */
    public MapSubject assertThat(Map<?, ?> actual) {
        return new MapSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(BigDecimal)}
     */
    public BigDecimalSubject assertThat(BigDecimal actual) {
        return new BigDecimalSubject(actual, message, tracker);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertWithMessage(String)}
     */
    public SoftAssertions assertWithMessage(String messageToPrepend) {
        this.message = messageToPrepend;
        return this;
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertWithMessage(String, Object...)}
     */
    public SoftAssertions assertWithMessage(String format, Object... args) {
        this.message = String.format(format, args);
        return this;
    }

    /**
     * Wrapper over {@link Truth#assert_()}
     */
    public void softFail() {
        try {
            Truth.assert_().fail();
        } catch (AssertionError e) {
            tracker.addError(message, e);
        }
    }

    /**
     * Wrapper over {@link Truth#assert_()#}
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
