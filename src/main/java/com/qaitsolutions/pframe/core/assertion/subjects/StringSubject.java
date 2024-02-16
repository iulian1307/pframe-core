package com.qaitsolutions.pframe.core.assertion.subjects;

import com.google.common.truth.Truth;
import com.qaitsolutions.pframe.core.assertion.ErrorTracker;
import com.qaitsolutions.pframe.core.assertion.FailProcessing;
import com.qaitsolutions.pframe.core.logging.Log;

import java.util.regex.Pattern;

/**
 * Wrapper over {@link com.google.common.truth.StringSubject}.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class StringSubject extends ComparableSubject<String> {

    private final String actual;

    /**
     * Constructor for regular assertions.
     * <p>
     *
     * @param actual  Current value to be verified.
     * @param message Description of the assertion.
     */
    public StringSubject(String actual, String message) {
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
    public StringSubject(String actual, String message, ErrorTracker tracker) {
        super(actual, message, tracker);
        this.actual = actual;
    }

    /**
     * Wrapper over {@link com.google.common.truth.StringSubject#hasLength(int)}.
     * <p>
     *
     * @param expected Value to be verified against.
     */
    public void hasLength(int expected) {
        try {
            Truth.assertThat(actual).hasLength(expected);
            Log.pass(message);
        } catch (AssertionError e) {
            FailProcessing.process(message, tracker, e);
        }
    }

    /**
     * Fails if the string is not equal to the zero-length "empty string." Wrapper over
     * {@link com.google.common.truth.StringSubject#isEmpty()}.
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
     * Fails if the string is equal to the zero-length "empty string." Wrapper over
     * {@link com.google.common.truth.StringSubject#isNotEmpty()}.
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
     * Fails if the string does not contain the given sequence. Wrapper over
     * {@link com.google.common.truth.StringSubject#contains(CharSequence)}.
     * <p>
     *
     * @param string Value to be verified against.
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
     * Fails if the string contains the given sequence. Wrapper over
     * {@link com.google.common.truth.StringSubject#doesNotContain(CharSequence)}.
     * <p>
     *
     * @param string Value to be verified against.
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
     * Fails if the string does not start with the given string. Wrapper over
     * {@link com.google.common.truth.StringSubject#startsWith(String)}.
     * <p>
     *
     * @param string Value to be verified against.
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
     * Fails if the string does not end with the given string. Wrapper over
     * {@link com.google.common.truth.StringSubject#endsWith(String)}.
     * <p>
     *
     * @param string Value to be verified against.
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
     * Fails if the string does not match the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#matches(String)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Fails if the string does not match the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#matches(Pattern)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Fails if the string matches the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#doesNotMatch(String)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Fails if the string matches the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#doesNotMatch(Pattern)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Fails if the string does not contain a match on the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#containsMatch(Pattern)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Fails if the string does not contain a match on the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#containsMatch(String)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Fails if the string contains a match on the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#doesNotContainMatch(Pattern)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Fails if the string contains a match on the given regex. Wrapper over
     * {@link com.google.common.truth.StringSubject#doesNotContainMatch(String)}.
     * <p>
     *
     * @param regex Value to be verified against.
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
     * Wrapper over {@link com.google.common.truth.StringSubject#ignoringCase()}.
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
         * Fails if the subject is not equal to the given sequence (while ignoring case). Wrapper over
         * {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#isEqualTo(String)}.
         * <p>
         *
         * @param expected Value to be verified against.
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
         * Fails if the subject is equal to the given string (while ignoring case). Wrapper over
         * {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#isNotEqualTo(String)}.
         * <p>
         *
         * @param unexpected Value to be verified against.
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
         * Fails if the string does not contain the given sequence (while ignoring case). Wrapper over
         * {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#contains(CharSequence)}.
         * <p>
         *
         * @param expectedSequence Value to be verified against.
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
         * Fails if the string contains the given sequence (while ignoring case). Wrapper over
         * {@link com.google.common.truth.StringSubject.CaseInsensitiveStringComparison#doesNotContain(CharSequence)}.
         * <p>
         *
         * @param expectedSequence Value to be verified against.
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
