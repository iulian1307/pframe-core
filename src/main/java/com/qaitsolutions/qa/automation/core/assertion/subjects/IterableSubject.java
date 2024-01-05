package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;

import java.util.Comparator;

/**
 * Wrapper over {@link com.google.common.truth.IterableSubject}
 */
public class IterableSubject extends Subject {

    private final Iterable<?> actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public IterableSubject(Iterable<?> actual, String message) {
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
    public IterableSubject(Iterable<?> actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    @Override
    public void isEqualTo(Object expected) {
        try {
            super.isEqualTo(expected);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#isEmpty()}
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
     * Wrapper over {@link com.google.common.truth.IterableSubject#isNotEmpty()}
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
     * Wrapper over {@link com.google.common.truth.IterableSubject#hasSize(int)}
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
     * Wrapper over {@link com.google.common.truth.IterableSubject#contains(Object)}
     */
    public final void contains(Object element) {
        try {
            Truth.assertThat(actual).contains(element);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#doesNotContain(Object)}
     */
    public final void doesNotContain(Object element) {
        try {
            Truth.assertThat(actual).doesNotContain(element);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsNoDuplicates()}
     */
    public final void containsNoDuplicates() {
        try {
            Truth.assertThat(actual).containsNoDuplicates();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAnyOf(Object, Object, Object...)}
     */
    public final void containsAnyOf(Object first, Object second, Object... rest) {
        try {
            Truth.assertThat(actual).containsAnyOf(first, second, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAnyIn(Iterable)}
     */
    public final void containsAnyIn(Iterable<?> expected) {
        try {
            Truth.assertThat(actual).containsAnyIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAnyIn(Object[])}
     */
    public final void containsAnyIn(Object[] expected) {
        try {
            Truth.assertThat(actual).containsAnyIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAtLeast(Object, Object, Object...)}
     */
    public final void containsAtLeast(Object firstExpected, Object secondExpected, Object... restOfExpected) {
        try {
            Truth.assertThat(actual).containsAtLeast(firstExpected, secondExpected, restOfExpected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAtLeastElementsIn(Iterable)}
     */
    public final void containsAtLeastElementsIn(Iterable<?> expectedIterable) {
        try {
            Truth.assertThat(actual).containsAtLeastElementsIn(expectedIterable);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAtLeastElementsIn(Object[])}
     */
    public final void containsAtLeastElementsIn(Object[] expected) {
        try {
            Truth.assertThat(actual).containsAtLeastElementsIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsExactly(Object...)}
     */
    public final void containsExactly(Object... varargs) {
        try {
            Truth.assertThat(actual).containsExactly(varargs);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsExactlyElementsIn(Iterable)}
     */
    public final void containsExactlyElementsIn(Iterable<?> expected) {
        try {
            Truth.assertThat(actual).containsExactlyElementsIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsExactlyElementsIn(Object[])}
     */
    public final void containsExactlyElementsIn(Object[] expected) {
        try {
            Truth.assertThat(actual).containsExactlyElementsIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsNoneOf(Object, Object, Object...)}
     */
    public final void containsNoneOf(Object firstExcluded, Object secondExcluded, Object... restOfExcluded) {
        try {
            Truth.assertThat(actual).containsNoneOf(firstExcluded, secondExcluded, restOfExcluded);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsNoneIn(Iterable)}
     */
    public final void containsNoneIn(Iterable<?> excluded) {
        try {
            Truth.assertThat(actual).containsNoneIn(excluded);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsNoneIn(Object[])}
     */
    public final void containsNoneIn(Object[] excluded) {
        try {
            Truth.assertThat(actual).containsNoneIn(excluded);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#isInStrictOrder()}
     */
    public void isInStrictOrder() {
        try {
            Truth.assertThat(actual).isInStrictOrder();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#isInStrictOrder(Comparator)}
     */
    public final void isInStrictOrder(final Comparator<?> comparator) {
        try {
            Truth.assertThat(actual).isInStrictOrder(comparator);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#isInOrder()}
     */
    public void isInOrder() {
        try {
            Truth.assertThat(actual).isInOrder();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.IterableSubject#isInOrder(Comparator)}
     */
    public final void isInOrder(final Comparator<?> comparator) {
        try {
            Truth.assertThat(actual).isInOrder(comparator);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
