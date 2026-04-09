package M1;

/**
 * Represents the configuration of the logging system.
 * Stores settings such as log file path, format, and connection strings
 * for different destinations.
 * This class only holds data and is managed by
 * the ConfigManager
 */

public class LogConfig {

    private String logFilePath;
    private String logFormat;
    private String dbConnectionString;
    private String azureConnectionString;

    public LogConfig(String logFilePath, String logFormat,
                     String dbConnectionString, String azureConnectionString) {
        this.logFilePath = logFilePath;
        this.logFormat = logFormat;
        this.dbConnectionString = dbConnectionString;
        this.azureConnectionString = azureConnectionString;
    }

    // Getters
    public String getLogFilePath() {
        return logFilePath;
    }

    public String getLogFormat() {
        return logFormat;
    }

    public String getDbConnectionString() {
        return dbConnectionString;
    }

    public String getAzureConnectionString() {
        return azureConnectionString;
    }

    // Setters 
    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }
}