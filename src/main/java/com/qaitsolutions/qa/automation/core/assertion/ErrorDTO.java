package com.qaitsolutions.qa.automation.core.assertion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Error DTO with {@link Object#toString()} method for prettifying
 */
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class ErrorDTO {
    private String description;
    private Throwable exception;

    @Override
    public String toString() {
        String toOutput = "";

        String description = this.description != null && !this.description.isEmpty()
                ? "[description] " + this.description
                : "";

        if (!description.isEmpty())
            toOutput = toOutput + description;

        String errorMessage = this.exception.getMessage() != null && !this.exception.getMessage().isEmpty()
                ? "[error_message] " + this.exception.getMessage()
                : "";

        if (!errorMessage.isEmpty())
            toOutput = (toOutput.isEmpty() ? "" : toOutput + "\n") + errorMessage;

        return toOutput;
    }
}
