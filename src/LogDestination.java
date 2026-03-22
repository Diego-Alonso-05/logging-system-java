


/**
 * Interface for log storage strategies.
 * Defines a common method to save logs,
 * allowing different storage implementations
 */



public interface LogDestination {
    void save(Log log);
}

