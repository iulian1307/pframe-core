package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;

import java.util.Map;

/**
 * Wrapper over {@link com.google.common.truth.MapSubject}
 */
public class MapSubject extends Subject {

    private final Map<?, ?> actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public MapSubject(Map<?, ?> actual, String message) {
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
    public MapSubject(Map<?, ?> actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    @Override
    public final void isEqualTo(Object other) {
        try {
            Truth.assertThat(actual).isEqualTo(other);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#isEmpty()}
     */
    public final void isEmpty() {
        try {
            Truth.assertThat(actual).isEmpty();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#isNotEmpty()}
     */
    public final void isNotEmpty() {
        try {
            Truth.assertThat(actual).isNotEmpty();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#hasSize(int)}
     */
    public final void hasSize(int expectedSize) {
        try {
            Truth.assertThat(actual).hasSize(expectedSize);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#containsKey(Object)}
     */
    public final void containsKey(Object key) {
        try {
            Truth.assertThat(actual).containsKey(key);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#doesNotContainKey(Object)}
     */
    public final void doesNotContainKey(Object key) {
        try {
            Truth.assertThat(actual).doesNotContainKey(key);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#containsEntry(Object, Object)}
     */
    public final void containsEntry(Object key, Object value) {
        try {
            Truth.assertThat(actual).containsEntry(key, value);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#doesNotContainEntry(Object, Object)}
     */
    public final void doesNotContainEntry(Object key, Object value) {
        try {
            Truth.assertThat(actual).doesNotContainEntry(key, value);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#containsExactly(Object, Object, Object...)}
     */
    public final void containsExactly(Object k0, Object v0, Object... rest) {
        try {
            Truth.assertThat(actual).containsExactly(k0, v0, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#containsAtLeast(Object, Object, Object...)}
     */
    public final void containsAtLeast(Object k0, Object v0, Object... rest) {
        try {
            Truth.assertThat(actual).containsAtLeast(k0, v0, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#containsExactlyEntriesIn(Map)}
     */
    public final void containsExactlyEntriesIn(Map<?, ?> expectedMap) {
        try {
            Truth.assertThat(actual).containsExactlyEntriesIn(expectedMap);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.MapSubject#containsAtLeastEntriesIn(Map)}
     */
    public final void containsAtLeastEntriesIn(Map<?, ?> expectedMap) {
        try {
            Truth.assertThat(actual).containsAtLeastEntriesIn(expectedMap);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
