package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;

import java.util.Comparator;

/**
 * Wrapper over {@link com.google.common.truth.IterableSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class IterableSubject extends Subject {

    private final Iterable<?> actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public IterableSubject(Iterable<?> actual, String message) {
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
     * Fails if the subject is not empty. Wrapper over {@link com.google.common.truth.IterableSubject#isEmpty()}.
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
     * Fails if the subject is empty. Wrapper over {@link com.google.common.truth.IterableSubject#isNotEmpty()}.
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
     * Fails if the subject does not have the given size. Wrapper over
     * {@link com.google.common.truth.IterableSubject#hasSize(int)}.
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
     * Checks (with a side-effect failure) that the subject contains the supplied item.
     * Wrapper over {@link com.google.common.truth.IterableSubject#contains(Object)}.
     * <p>
     *
     * @param element Value to be verified against.
     */
    public void contains(Object element) {
        try {
            Truth.assertThat(actual).contains(element);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks (with a side-effect failure) that the subject does not contain the supplied item.
     * Wrapper over {@link com.google.common.truth.IterableSubject#doesNotContain(Object)}.
     * <p>
     *
     * @param element Value to be verified against.
     */
    public void doesNotContain(Object element) {
        try {
            Truth.assertThat(actual).doesNotContain(element);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject does not contain duplicate elements. Wrapper over
     * {@link com.google.common.truth.IterableSubject#containsNoDuplicates()}.
     */
    public void containsNoDuplicates() {
        try {
            Truth.assertThat(actual).containsNoDuplicates();
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject contains at least one of the provided objects or fails. Wrapper over
     * {@link com.google.common.truth.IterableSubject#containsAnyOf(Object, Object, Object...)}.
     * <p>
     *
     * @param first  Value to be verified against.
     * @param second Value to be verified against.
     * @param rest   Value to be verified against.
     */
    public void containsAnyOf(Object first, Object second, Object... rest) {
        try {
            Truth.assertThat(actual).containsAnyOf(first, second, rest);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject contains at least one of the objects contained in the provided collection
     * or fails. Wrapper over {@link com.google.common.truth.IterableSubject#containsAnyIn(Iterable)}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void containsAnyIn(Iterable<?> expected) {
        try {
            Truth.assertThat(actual).containsAnyIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the subject contains at least one of the objects contained in the provided array or
     * fails. Wrapper over {@link com.google.common.truth.IterableSubject#containsAnyIn(Object[])}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void containsAnyIn(Object[] expected) {
        try {
            Truth.assertThat(actual).containsAnyIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the actual iterable contains at least all of the expected elements or fails.
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAtLeast(Object, Object, Object...)}.
     * <p>
     *
     * @param firstExpected  Value to be verified against.
     * @param secondExpected Value to be verified against.
     * @param restOfExpected Value to be verified against.
     */
    public void containsAtLeast(Object firstExpected, Object secondExpected, Object... restOfExpected) {
        try {
            Truth.assertThat(actual).containsAtLeast(firstExpected, secondExpected, restOfExpected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the actual iterable contains at least all of the expected elements or fails.
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAtLeastElementsIn(Iterable)}.
     * <p>
     *
     * @param expectedIterable Value to be verified against.
     */
    public void containsAtLeastElementsIn(Iterable<?> expectedIterable) {
        try {
            Truth.assertThat(actual).containsAtLeastElementsIn(expectedIterable);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the actual iterable contains at least all of the expected elements or fails.
     * Wrapper over {@link com.google.common.truth.IterableSubject#containsAtLeastElementsIn(Object[])}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void containsAtLeastElementsIn(Object[] expected) {
        try {
            Truth.assertThat(actual).containsAtLeastElementsIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that a subject contains exactly the provided objects or fails. Wrapper over
     * {@link com.google.common.truth.IterableSubject#containsExactly(Object...)}.
     * <p>
     *
     * @param varargs Value to be verified against.
     */
    public void containsExactly(Object... varargs) {
        try {
            Truth.assertThat(actual).containsExactly(varargs);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that a subject contains exactly the provided objects or fails. Wrapper over
     * {@link com.google.common.truth.IterableSubject#containsExactlyElementsIn(Iterable)}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void containsExactlyElementsIn(Iterable<?> expected) {
        try {
            Truth.assertThat(actual).containsExactlyElementsIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that a subject contains exactly the provided objects or fails. Wrapper over
     * {@link com.google.common.truth.IterableSubject#containsExactlyElementsIn(Object[])}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void containsExactlyElementsIn(Object[] expected) {
        try {
            Truth.assertThat(actual).containsExactlyElementsIn(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that a actual iterable contains none of the excluded objects or fails. Wrapper over
     * {@link com.google.common.truth.IterableSubject#containsNoneOf(Object, Object, Object...)}.
     * <p>
     *
     * @param firstExcluded  Value to be verified against.
     * @param secondExcluded Value to be verified against.
     * @param restOfExcluded Value to be verified against.
     */
    public void containsNoneOf(Object firstExcluded, Object secondExcluded, Object... restOfExcluded) {
        try {
            Truth.assertThat(actual).containsNoneOf(firstExcluded, secondExcluded, restOfExcluded);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the actual iterable contains none of the elements contained in the excluded iterable
     * or fails. Wrapper over {@link com.google.common.truth.IterableSubject#containsNoneIn(Iterable)}.
     * <p>
     *
     * @param excluded Value to be verified against.
     */
    public void containsNoneIn(Iterable<?> excluded) {
        try {
            Truth.assertThat(actual).containsNoneIn(excluded);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Checks that the actual iterable contains none of the elements contained in the excluded array
     * or fails. Wrapper over {@link com.google.common.truth.IterableSubject#containsNoneIn(Object[])}.
     * <p>
     *
     * @param excluded Value to be verified against.
     */
    public void containsNoneIn(Object[] excluded) {
        try {
            Truth.assertThat(actual).containsNoneIn(excluded);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the iterable is not strictly ordered, according to the natural ordering of its elements.
     * Wrapper over {@link com.google.common.truth.IterableSubject#isInStrictOrder()}.
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
     * Fails if the iterable is not strictly ordered, according to the given comparator. Wrapper over
     * {@link com.google.common.truth.IterableSubject#isInStrictOrder(Comparator)}.
     * <p>
     *
     * @param comparator Value to be verified against.
     */
    public void isInStrictOrder(final Comparator<?> comparator) {
        try {
            Truth.assertThat(actual).isInStrictOrder(comparator);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the iterable is not ordered, according to the natural ordering of its elements. Wrapper over
     * {@link com.google.common.truth.IterableSubject#isInOrder()}.
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
     * Fails if the iterable is not ordered, according to the given comparator. Wrapper over
     * {@link com.google.common.truth.IterableSubject#isInOrder(Comparator)}.
     * <p>
     *
     * @param comparator Value to be verified against.
     */
    public void isInOrder(final Comparator<?> comparator) {
        try {
            Truth.assertThat(actual).isInOrder(comparator);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }
}
