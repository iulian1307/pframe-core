package com.qaitsolutions.qa.automation.core.assertion.subjects;


import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;

/**
 * Wrapper over {@link com.google.common.truth.IntegerSubject}
 */
public class IntegerSubject extends ComparableSubject<Integer> {

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public IntegerSubject(Integer actual, String message) {
        super(actual, message);
    }

    /**
     * Constructor for soft assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     * @param tracker Entity which allows keeping track of existing errors
     */
    public IntegerSubject(Integer actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
    }
}
