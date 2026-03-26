/**
 * Represents a debug log message.
 */
public class DebugLog extends Log {

    public DebugLog(String message) {
        super(message);
        this.level = LogLevel.DEBUG;
    }
}