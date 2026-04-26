package design.brdd.core.base;

import design.brdd.core.ValidateService;
import design.brdd.core.ValidationContext;
import design.brdd.core.annotations.BrddRule;

import java.lang.reflect.Method;

/**
 * Base class for ValidateServices that use declarative annotations.
 * <p>
 * This class automatically discovers all methods annotated with {@link BrddRule} 
 * and executes them against the enriched data. This eliminates the need for 
 * manual loops and error handling in specific validators.
 *
 * @param <E> The type of the enriched data to be validated.
 */
public abstract class AbstractValidateService<E> implements ValidateService<E> {

    @Override
    public ValidationContext validate(E enrichedData) {
        ValidationContext context = ValidationContext.build();
        
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BrddRule.class)) {
                BrddRule rule = method.getAnnotation(BrddRule.class);
                try {
                    method.setAccessible(true);
                    Object result = method.invoke(this, enrichedData);
                    
                    if (result instanceof Boolean && !(Boolean) result) {
                        context.addError(rule.id(), rule.message());
                    }
                    // Future: support returning ValidationContext directly
                } catch (Exception e) {
                    throw new RuntimeException("Failed to execute business rule: " + rule.id(), e);
                }
            }
        }
        
        return context;
    }
}
