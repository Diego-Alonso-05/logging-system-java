package M1;

/**
 * Singleton that manages the global logging configuration.
 * Provides a single access point to the LogConfig instance,
 * ensuring consistency across the application
 */

public enum ConfigManager {

    INSTANCE;

    private LogConfig config;

    // Enum constructor
    ConfigManager() {
        config = new LogConfig(
                "C:\\Users\\di17j\\OneDrive\\Escritorio\\JavaProyects\\Registo_Logs\\logs\\logs.txt",
                "{timestamp} - {level} - {message}",
                "jdbc:mysql://localhost:3306/mydb",
                "DefaultAzureConnection"
        );
    }
    public LogConfig getConfig() {
        return config;
    }

    public void setConfig(LogConfig config) {
        this.config = config;
    }
}

