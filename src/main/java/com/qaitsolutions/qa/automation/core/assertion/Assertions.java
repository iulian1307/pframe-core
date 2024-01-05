package com.qaitsolutions.qa.automation.core.assertion;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.subjects.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Wrapper over {@link com.google.common.truth.Truth}
 */
public class Assertions {

    private String message;

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Integer)}
     */
    public IntegerSubject assertThat(Integer actual) {
        return new IntegerSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Iterable)}
     */
    public IterableSubject assertThat(Iterable<?> actual) {
        return new IterableSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Boolean)}
     */
    public BooleanSubject assertThat(Boolean actual) {
        return new BooleanSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Double)}
     */
    public DoubleSubject assertThat(Double actual) {
        return new DoubleSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Float)}
     */
    public DoubleSubject assertThat(Float actual) {
        return new DoubleSubject(actual.doubleValue(), message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Long)}
     */
    public LongSubject assertThat(Long actual) {
        return new LongSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(String)}
     */
    public StringSubject assertThat(String actual) {
        return new StringSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Comparable)}
     */
    public <T extends Comparable<?>> ComparableSubject<T> assertThat(T actual) {
        return new ComparableSubject<>(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Object)}
     */
    public Subject assertThat(Object actual) {
        return new Subject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(Map)}
     */
    public MapSubject assertThat(Map<?, ?> actual) {
        return new MapSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertThat(BigDecimal)}
     */
    public BigDecimalSubject assertThat(BigDecimal actual) {
        return new BigDecimalSubject(actual, message);
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertWithMessage(String)}
     */
    public Assertions assertWithMessage(String messageToPrepend) {
        this.message = messageToPrepend;
        return this;
    }

    /**
     * Wrapper over {@link com.google.common.truth.Truth#assertWithMessage(String, Object...)}
     */
    public Assertions assertWithMessage(String format, Object... args) {
        this.message = String.format(format, args);
        return this;
    }

    /**
     * Wrapper over {@link Truth#assert_()#fail()}
     */
    public void fail() {
        try {
            Truth.assert_().fail();
        } catch (AssertionError e) {
            FailProcessing.process(message, null, e);
        }
    }
}
