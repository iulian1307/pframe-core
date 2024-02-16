package com.qaitsolutions.pframe.core.assertion.subjects;


import com.qaitsolutions.pframe.core.assertion.ErrorTracker;

/**
 * Wrapper over {@link com.google.common.truth.IntegerSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class IntegerSubject extends ComparableSubject<Integer> {

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public IntegerSubject(Integer actual, String message) {
        super(actual, message);
    }

    /**
     * Constructor for soft assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     * @param tracker Entity which allows keeping track of existing errors.
     */
    public IntegerSubject(Integer actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
    }
}
