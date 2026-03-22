

/**
 * Log destination that outputs logs to the console.
 *
 * Mainly used for debugging and testing purposes
 */


public class ConsoleLogDestination implements LogDestination {

    @Override
    public void save(Log log) {
        System.out.println("Console: " + log.getMessage());
    }
}