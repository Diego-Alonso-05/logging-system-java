
/**
 * Log destination that simulates sending logs to a cloud service.
 * Uses the Azure connection string from the global configuration
 * to handle remote logging.
 */

public class AzureLogDestination implements LogDestination {

    @Override
    public void save(Log log) {
        //TODO: Real logic for azure services
        String azure = ConfigManager.INSTANCE.getConfig().getAzureConnectionString();
        System.out.println("Saving to Azure: " + azure + " -> " + log.getMessage());
    }
}