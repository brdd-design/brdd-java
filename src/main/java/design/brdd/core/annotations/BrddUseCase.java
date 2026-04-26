package design.brdd.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a class as a BRDD Use Case.
 * <p>
 * Using this annotation allows the framework to automatically discover 
 * the Use Case ID and initialize the ExecutionContext accordingly.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BrddUseCase {
    /**
     * @return The unique business identifier for this use case (e.g., UC_EDU_001).
     */
    String id();
}
