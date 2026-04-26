package design.brdd.core;

/**
 * Protocol for client services that wrap external domain calls (APIs, Webhooks, ERPs, etc).
 * 
 * @param <D> Payload Data Type
 * @param <R> External Result Type
 */
@FunctionalInterface
public interface ClientService<D, R> {
    /**
     * Calls the external service and maps internal data to the external format.
     *
     * @param payload The data to send.
     * @return The external result.
     */
    R call(D payload);
}
