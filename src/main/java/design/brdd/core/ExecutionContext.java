package design.brdd.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The central state object returned by UseCases.
 * Encapsulates the ValidationContext, setters, effects, and resulting data.
 * 
 * @param <T> Return Data Type
 */
public final class ExecutionContext<T> {
    public static final String PRE_EFFECT = "PRE";
    public static final String POST_EFFECT = "POST";

    private final String useCaseCode;
    private final ValidationContext validationContext;
    private final Map<String, Object> setters = new HashMap<>();
    private final List<EffectEntry> effects = new ArrayList<>();
    private T data = null;

    private ExecutionContext(String useCaseCode, ValidationContext validationContext) {
        this.useCaseCode = useCaseCode;
        this.validationContext = validationContext;
    }

    /**
     * Factory method to build the ExecutionContext.
     *
     * @param useCaseCode The code identifying the UseCase.
     * @param validationContext The validation results.
     * @param <T> The data type.
     * @return A new ExecutionContext.
     */
    public static <T> ExecutionContext<T> build(String useCaseCode, ValidationContext validationContext) {
        return new ExecutionContext<>(useCaseCode, validationContext);
    }

    /**
     * Registers a side effect to be executed.
     *
     * @param type PRE_EFFECT or POST_EFFECT.
     * @param code Unique code for the effect.
     * @param action The logic to execute.
     */
    public void addEffect(String type, String code, Runnable action) {
        this.effects.add(new EffectEntry(type, code, action));
    }

    /**
     * Records a state mutation (Setter) for auditing.
     *
     * @param code The setter code.
     * @param value The value set.
     */
    public void addSetter(String code, Object value) {
        this.setters.put(code, value);
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getUseCaseCode() {
        return useCaseCode;
    }

    public ValidationContext getValidationContext() {
        return validationContext;
    }

    public boolean hasErrors() {
        return validationContext.hasErrors();
    }

    public Map<String, Object> getSetters() {
        return Collections.unmodifiableMap(setters);
    }

    public List<EffectEntry> getEffects() {
        return Collections.unmodifiableList(effects);
    }

    /**
     * Represents a registered side effect.
     */
    public record EffectEntry(String type, String code, Runnable action) {
    }
}
