package M2;

import M0.Log;
import M0.LogLevel;

/**
 * Represents an error log message.
 */
public class ErrorLog extends Log {

    public ErrorLog(String message) {
        super(message);
        this.level = LogLevel.ERROR;
    }
}