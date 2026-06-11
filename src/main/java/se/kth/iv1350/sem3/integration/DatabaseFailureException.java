package se.kth.iv1350.sem3.integration;

/**
 * Thrown when the database can not be called.
 */
public class DatabaseFailureException extends RuntimeException {
    /**
     * Creates a new exception with a message explaining the database failure.
     *
     * @param message A message explaining the failure.
     */
    public DatabaseFailureException(String message) {
        super(message);
    }
}