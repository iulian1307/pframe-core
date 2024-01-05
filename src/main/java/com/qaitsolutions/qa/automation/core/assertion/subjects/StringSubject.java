package com.qaitsolutions.qa.automation.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.qa.automation.core.assertion.ErrorTracker;
import com.qaitsolutions.qa.automation.core.assertion.FailProcessing;
import com.qaitsolutions.qa.automation.core.testng.Log;

import java.util.regex.Pattern;

/**
 * Wrapper over {@link com.google.common.truth.StringSubject}
 */
public class StringSubject extends ComparableSubject<String> {

    private final String actual;

    /**
     * Constructor for regular assertions
     *
     * @param actual  Current value to be verified
     * @param message Description of the assertion
     */
    public StringSubject(String actual, String message) {
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
    public StringSubject(String actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#hasLength(int)}
     */
    public void hasLength(int expectedLength) {
        try {
            Truth.assertThat(actual).hasLength(expectedLength);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#isEmpty()}
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
     * Wrapper over {@link com.google.common.truth.StringSubject#isNotEmpty()}
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
     * Wrapper over {@link com.google.common.truth.StringSubject#contains(CharSequence)}
     */
    public void contains(CharSequence string) {
        try {
            Truth.assertThat(actual).contains(string);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#doesNotContain(CharSequence)}
     */
    public void doesNotContain(CharSequence string) {
        try {
            Truth.assertThat(actual).doesNotContain(string);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#startsWith(String)}
     */
    public void startsWith(String string) {
        try {
            Truth.assertThat(actual).startsWith(string);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#endsWith(String)}
     */
    public void endsWith(String string) {
        try {
            Truth.assertThat(actual).endsWith(string);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#matches(String)}
     */
    public void matches(String regex) {
        try {
            Truth.assertThat(actual).matches(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#matches(Pattern)}
     */
    public void matches(Pattern regex) {
        try {
            Truth.assertThat(actual).matches(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#doesNotMatch(String)}
     */
    public void doesNotMatch(String regex) {
        try {
            Truth.assertThat(actual).doesNotMatch(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#doesNotMatch(Pattern)}
     */
    public void doesNotMatch(Pattern regex) {
        try {
            Truth.assertThat(actual).doesNotMatch(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#containsMatch(Pattern)}
     */
    public void containsMatch(Pattern regex) {
        try {
            Truth.assertThat(actual).containsMatch(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#containsMatch(String)}
     */
    public void containsMatch(String regex) {
        try {
            Truth.assertThat(actual).containsMatch(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#doesNotContainMatch(Pattern)}
     */
    public void doesNotContainMatch(Pattern regex) {
        try {
            Truth.assertThat(actual).doesNotContainMatch(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#doesNotContainMatch(String)}
     */
    public void doesNotContainMatch(String regex) {
        try {
            Truth.assertThat(actual).doesNotContainMatch(regex);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#ignoringCase()}
     */
    public CaseInsensitiveStringComparison ignoringCase() {
        return new CaseInsensitiveStringComparison();
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison}
     */
    public final class CaseInsensitiveStringComparison {

        private CaseInsensitiveStringComparison() {
        }

        /**
         * Wrapper over {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#isEqualTo(String)}
         */
        public void isEqualTo(String expected) {
            try {
                Truth.assertThat(actual).ignoringCase().isEqualTo(expected);
                Log.pass(message);
            } catch (AssertionError e) {
                FailProcessing.process(message, tracker, e);
            }
        }

        /**
         * Wrapper over {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#isNotEqualTo(String)}
         */
        public void isNotEqualTo(String unexpected) {
            try {
                Truth.assertThat(actual).ignoringCase().isNotEqualTo(unexpected);
                Log.pass(message);
            } catch (AssertionError e) {
                FailProcessing.process(message, tracker, e);
            }
        }

        /**
         * Wrapper over {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#contains(CharSequence)}
         */
        public void contains(CharSequence expectedSequence) {
            try {
                Truth.assertThat(actual).ignoringCase().contains(expectedSequence);
                Log.pass(message);
            } catch (AssertionError e) {
                FailProcessing.process(message, tracker, e);
            }
        }

        /**
         * Wrapper over {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#doesNotContain(CharSequence)}
         */
        public void doesNotContain(CharSequence expectedSequence) {
            try {
                Truth.assertThat(actual).ignoringCase().doesNotContain(expectedSequence);
                Log.pass(message);
            } catch (AssertionError e) {
                FailProcessing.process(message, tracker, e);
            }
        }
    }
}
