package design.brdd.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a method as a Business Rule within a ValidateService.
 * <p>
 * Methods annotated with {@code @BrddRule} should ideally return a {@code boolean} 
 * (true for success, false for violation).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BrddRule {
    /**
     * @return The unique identifier of the business rule (e.g., R001).
     */
    String id();

    /**
     * @return The default human-readable message if the rule is violated.
     */
    String message() default "";
}
