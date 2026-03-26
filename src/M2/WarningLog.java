package M2;

import M0.Log;
import M0.LogLevel;
/**
 * Represents a warning log message.
 */
public class WarningLog extends Log {

    public WarningLog(String message) {
        super(message);
        this.level = LogLevel.WARNING;
    }
}