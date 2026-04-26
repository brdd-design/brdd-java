package design.brdd.core;

/**
 * Protocol for services that query and aggregate additional data needed for the UseCase.
 * EnrichServices MUST NOT contain business logic or validations.
 * 
 * @param <I> Input DTO Type
 * @param <E> Enriched Data Output Type
 */
@FunctionalInterface
public interface EnrichService<I, E> {
    /**
     * Enriches the input data by fetching dependencies.
     *
     * @param input The raw input data.
     * @return The aggregated enriched data.
     */
    E enrich(I input);
}
