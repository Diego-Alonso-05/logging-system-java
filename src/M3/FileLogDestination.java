package M3;

import M0.Log;
import M1.ConfigManager;

/**
 * Log destination that handles file-based logging.
 *
 * Retrieves the file path from the global configuration
 * and writes log messages to that file
 *
 * The current implementation may simulate file storage,
 * but it can be extended to perform real file persistence
 */



public class FileLogDestination implements LogDestination {

    @Override
    public void save(Log log) {
        LogConfig config = ConfigManager.INSTANCE.getConfig();
        String path = config.getLogFilePath();
        String format = config.getLogFormat();

        String formattedLog = formatLog(format, log);

        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(formattedLog);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + path);
        }
    }

    private String formatLog(String format, Log log) {

        if (format == null || format.isEmpty()) {
            return "[" + log.getLevel() + "] " + log.getMessage();
        }

        return format
                .replace("{level}", log.getLevel().toString())
                .replace("{message}", log.getMessage())
                .replace("{timestamp}", LocalDateTime.now().toString());
    }
}