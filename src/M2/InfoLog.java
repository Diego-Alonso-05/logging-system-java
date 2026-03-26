package M2;

import M0.Log;
import M0.LogLevel;

/**
 * Represents an informational log message
 * Sets the log level to INFO and formats the message accordingly.
 */


public class InfoLog extends Log {

    public InfoLog(String message) {
        super(message);
        this.level = LogLevel.INFO;
        formatMessage();
    }

    @Override
    public void formatMessage() {
        this.message = "INFO: " + message;
    }
}