package design.brdd.core;

/**
 * The orchestrator interface.
 * A UseCase coordinates services but does not execute business logic directly.
 * 
 * @param <I> Input DTO Type
 * @param <O> Output/Result DTO Type
 */
@FunctionalInterface
public interface UseCase<I, O> {
    /**
     * Executes the orchestration logic.
     *
     * @param input The raw request payload or internal DTO.
     * @return The resulting execution context containing data, errors, setters, and effects.
     */
    ExecutionContext<O> execute(I input);
}
