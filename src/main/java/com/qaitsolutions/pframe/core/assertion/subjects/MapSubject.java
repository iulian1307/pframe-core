package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;

import java.util.Map;

/**
 * Wrapper over {@link com.google.common.truth.MapSubject}
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class MapSubject extends Subject {

    private final Map<?, ?> actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public MapSubject(Map<?, ?> actual, String message) {
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
    public MapSubject(Map<?, ?> actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    @Override
    public void isEqualTo(Object other) {
        try {
            Truth.assertThat(actual).isEqualTo(other);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map is not empty. Wrapper over {@link com.google.common.truth.MapSubject#isEmpty()}.
     */
    public void isEmpty() {
        try {
            Truth.assertThat(actual).isEmpty();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map is empty. Wrapper over {@link com.google.common.truth.MapSubject#isNotEmpty()}.
     */
    public void isNotEmpty() {
        try {
            Truth.assertThat(actual).isNotEmpty();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map does not have the given size. Wrapper over
     * {@link com.google.common.truth.MapSubject#hasSize(int)}.
     * <p>
     *
     * @param expectedSize Value to be verified against.
     */
    public void hasSize(int expectedSize) {
        try {
            Truth.assertThat(actual).hasSize(expectedSize);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map does not contain the given key. Wrapper over
     * {@link com.google.common.truth.MapSubject#containsKey(Object)}.
     * <p>
     *
     * @param key Value to be verified against.
     */
    public void containsKey(Object key) {
        try {
            Truth.assertThat(actual).containsKey(key);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map contains the given key. Wrapper over
     * {@link com.google.common.truth.MapSubject#doesNotContainKey(Object)}.
     * <p>
     *
     * @param key Value to be verified against.
     */
    public void doesNotContainKey(Object key) {
        try {
            Truth.assertThat(actual).doesNotContainKey(key);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map does not contain the given entry. Wrapper over
     * {@link com.google.common.truth.MapSubject#containsEntry(Object, Object)}.
     * <p>
     *
     * @param key   Value to be verified against.
     * @param value Value to be verified against.
     */
    public void containsEntry(Object key, Object value) {
        try {
            Truth.assertThat(actual).containsEntry(key, value);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map contains the given entry. Wrapper over
     * {@link com.google.common.truth.MapSubject#doesNotContainEntry(Object, Object)}.
     * <p>
     *
     * @param key   Value to be verified against.
     * @param value Value to be verified against.
     */
    public void doesNotContainEntry(Object key, Object value) {
        try {
            Truth.assertThat(actual).doesNotContainEntry(key, value);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map does not contain exactly the given set of key/value pairs. Wrapper over
     * {@link com.google.common.truth.MapSubject#containsExactly(Object, Object, Object...)}.
     * <p>
     *
     * @param k0   Value to be verified against.
     * @param v0   Value to be verified against.
     * @param rest Value to be verified against.
     */
    public void containsExactly(Object k0, Object v0, Object... rest) {
        try {
            Truth.assertThat(actual).containsExactly(k0, v0, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map does not contain at least the given set of entries in the given map.
     * Wrapper over {@link com.google.common.truth.MapSubject#containsAtLeast(Object, Object, Object...)}.
     * <p>
     *
     * @param k0   Value to be verified against.
     * @param v0   Value to be verified against.
     * @param rest Value to be verified against.
     */
    public void containsAtLeast(Object k0, Object v0, Object... rest) {
        try {
            Truth.assertThat(actual).containsAtLeast(k0, v0, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map does not contain exactly the given set of entries in the given map.
     * Wrapper over {@link com.google.common.truth.MapSubject#containsExactlyEntriesIn(Map)}.
     * <p>
     *
     * @param expectedMap Value to be verified against.
     */
    public void containsExactlyEntriesIn(Map<?, ?> expectedMap) {
        try {
            Truth.assertThat(actual).containsExactlyEntriesIn(expectedMap);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the map does not contain at least the given set of entries in the given map.
     * Wrapper over {@link com.google.common.truth.MapSubject#containsAtLeastEntriesIn(Map)}.
     * <p>
     *
     * @param expectedMap Value to be verified against.
     */
    public void containsAtLeastEntriesIn(Map<?, ?> expectedMap) {
        try {
            Truth.assertThat(actual).containsAtLeastEntriesIn(expectedMap);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
