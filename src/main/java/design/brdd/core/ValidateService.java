package design.brdd.core;

/**
 * Protocol for services dedicated exclusively to pure business logic validation.
 * ValidateServices MUST NOT fetch data; they evaluate pre-enriched data.
 * 
 * @param <E> Enriched Data Input Type
 */
@FunctionalInterface
public interface ValidateService<E> {
    /**
     * Evaluates rules against enriched data and returns a ValidationContext.
     *
     * @param enrichedData The data to be validated.
     * @return The validation context containing any errors found.
     */
    ValidationContext validate(E enrichedData);
}
