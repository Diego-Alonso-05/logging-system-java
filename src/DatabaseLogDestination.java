

/**
 * Log destination that handles database storage.
 *
 * Uses the database connection string from the global
 * configuration to store log messages
 */

public class DatabaseLogDestination implements LogDestination {

    @Override
    public void save(Log log) {

        //TODO: Real connection, this is a simulation

        String db = ConfigManager.INSTANCE.getConfig().getDbConnectionString();
        System.out.println("Saving to DB: " + db + " -> " + log.getMessage());
    }
}