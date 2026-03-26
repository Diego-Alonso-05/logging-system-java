package M2;

import M0.Log;
import M0.LogLevel;

/**
 * Factory class responsible for creating Log objects.
 * Encapsulates the instantiation logic and returns
 * the appropriate log type based on the given level
 */


public class LogFactory {

    public static Log createLog(LogLevel level, String message) {

        switch (level) {
            case INFO:
                return new InfoLog(message);
            case WARNING:
                return new WarningLog(message);
            case ERROR:
                return new ErrorLog(message);
            case DEBUG:
                return new DebugLog(message);
            default:
                throw new IllegalArgumentException("Invalid log level");
        }
    }
}