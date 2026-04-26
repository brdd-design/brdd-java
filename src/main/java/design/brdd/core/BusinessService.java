package design.brdd.core;

/**
 * Protocol for services executing pure core business operations and state mutations.
 * 
 * @param <E> Enriched Data Input Type
 * @param <R> Business Result Type
 */
@FunctionalInterface
public interface BusinessService<E, R> {
    /**
     * Executes the main business logic and returns a result.
     *
     * @param contextData The data to operate on.
     * @return The operation result.
     */
    R execute(E contextData);
}
