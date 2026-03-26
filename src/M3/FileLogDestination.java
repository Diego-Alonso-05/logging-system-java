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
        String path = ConfigManager.INSTANCE.getConfig().getLogFilePath();
        System.out.println("Saving to file: " + path + " -> " + log.getMessage());
    }
    //TODO:Logic for real storage of logs on the device
}


