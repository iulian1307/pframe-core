package com.qaitsolutions.qa.automation.core.assertion;


import com.qaitsolutions.qa.automation.core.testng.Log;

/**
 * Entity takes data from assertion and process it
 */
public class FailProcessing {

    /**
     * Takes data from the assertion and either throws the proper error or adds it tracker.
     *
     * @param message Description of the assertion
     * @param tracker Entity used to track errors
     * @param e       Exception thrown in failed assertion
     * @throws AssertionError Throws {@link AssertionError} if tracker is not present. If tracker is present
     *                        error is added to tracker.
     */
    public static void process(String message, ErrorTracker tracker, Throwable e) {
        if (tracker != null) {
            if (message != null && !message.isEmpty()) {
                tracker.addError(message, e);
                return;
            }

            tracker.addError(e);
            return;
        }

        Log.fail(message, e);
        throw new AssertionError(e);
    }
}
