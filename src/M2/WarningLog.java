package M2;

import M0.Log;
import M0.LogLevel;
/**
 * Represents a warning log message.
 *
 * Sets the log level to WARNING and formats the message accordingly
 */


public class WarningLog extends Log {

    public WarningLog(String message) {
        super(message);
        this.level = LogLevel.WARNING;
        formatMessage();
    }

    @Override
    public void formatMessage() {
        this.message = "WARNING: " + message;
    }
}