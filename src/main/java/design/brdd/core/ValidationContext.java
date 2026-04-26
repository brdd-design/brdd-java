package design.brdd.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encapsulates validation results and errors.
 */
public final class ValidationContext {
    private final List<BrddError> errors = new ArrayList<>();

    private ValidationContext() {}

    /**
     * Factory method to build a new context.
     * @return A new ValidationContext instance.
     */
    public static ValidationContext build() {
        return new ValidationContext();
    }

    /**
     * Adds an error to the context.
     *
     * @param code The error code.
     * @param message The error message.
     */
    public void addError(String code, String message) {
        this.errors.add(new BrddError(code, message));
    }

    /**
     * Checks if there are any validation errors.
     *
     * @return true if errors exist.
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * Returns an unmodifiable list of errors.
     *
     * @return List of BrddError.
     */
    public List<BrddError> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
